package Session7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class GiftConfig {
    String giftCode;
    String giftName;
    double rate;
    boolean free;
    int limitTotal;
    int limitPlayer;

    public GiftConfig(String giftCode, String giftName, double rate, boolean free, int limitTotal, int limitPlayer) {
        this.giftCode = giftCode;
        this.giftName = giftName;
        this.rate = rate;
        this.free = free;
        this.limitTotal = limitTotal;
        this.limitPlayer = limitPlayer;
    }
}

class Player {
    String playerCode;
    String playerName;

    public Player(String playerCode, String playerName) {
        this.playerCode = playerCode;
        this.playerName = playerName;
    }
}

class GiftHistory {
    String giftCode;
    String playerCode;

    public GiftHistory(String giftCode, String playerCode) {
        this.giftCode = giftCode;
        this.playerCode = playerCode;
    }
}

public class RewardGame {
    private static Map<String, Player> players = new HashMap<>();
    private static List<GiftConfig> giftConfigs = new ArrayList<>();
    private static List<GiftHistory> giftHistories = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Nhập mã người chơi để trả quà");
            System.out.println("2. Nhập playerCode để xem danh sách quà đã nhận");
            System.out.println("3. Thoát");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    rewardGift(scanner);
                    break;
                case 2:
                    viewGiftHistory(scanner);
                    break;
                case 3:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void initializeData() {
        players.put("001", new Player("001", "Player1"));
        players.put("002", new Player("002", "Player2"));

        giftConfigs.add(new GiftConfig("G001", "Gift1", 0.3, false, 10, 2));
        giftConfigs.add(new GiftConfig("G002", "Gift2", 0.2, false, 5, 1));
        giftConfigs.add(new GiftConfig("G003", "FreeGift", 0, true, 20, 5));
    }

    private static void rewardGift(Scanner scanner) {
        System.out.println("Nhập mã người chơi (playerCode): ");
        String playerCode = scanner.nextLine();

        Player player = players.get(playerCode);
        if (player == null) {
            System.out.println("Người chơi không tồn tại.");
            return;
        }

        System.out.println("Đang trả quà cho người chơi: " + player.playerName);

        GiftConfig selectedGift = getRandomGift();
        if (selectedGift == null) {
            System.out.println("Không còn quà để trả. Trả một phần quà không giá trị.");
            selectedGift = getRandomFreeGift();
        }

        System.out.println("Đã nhận quà: " + selectedGift.giftName);

        GiftHistory giftHistory = new GiftHistory(selectedGift.giftCode, playerCode);
        giftHistories.add(giftHistory);

        updateGiftCount(selectedGift);
    }

    private static GiftConfig getRandomGift() {
        Random random = new Random();
        for (GiftConfig giftConfig : giftConfigs) {
            if (giftConfig.limitTotal > 0 && giftConfig.limitPlayer > 0 && random.nextDouble() <= giftConfig.rate) {
                return giftConfig;
            }
        }
        return null;
    }

    private static GiftConfig getRandomFreeGift() {
        Random random = new Random();
        for (GiftConfig giftConfig : giftConfigs) {
            if (giftConfig.limitTotal > 0 && giftConfig.limitPlayer > 0 && giftConfig.free) {
                return giftConfig;
            }
        }
        return null;
    }

    private static void updateGiftCount(GiftConfig selectedGift) {
        selectedGift.limitTotal--;
        selectedGift.limitPlayer--;
    }

    private static void viewGiftHistory(Scanner scanner) {
        System.out.println("Nhập mã người chơi (playerCode) để xem danh sách quà đã nhận: ");
        String playerCode = scanner.nextLine();

        System.out.println("Danh sách quà đã nhận:");
        for (GiftHistory giftHistory : giftHistories) {
            if (giftHistory.playerCode.equals(playerCode)) {
                System.out.println("Quà: " + getGiftName(giftHistory.giftCode));
            }
        }
    }

    private static String getGiftName(String giftCode) {
        for (GiftConfig giftConfig : giftConfigs) {
            if (giftConfig.giftCode.equals(giftCode)) {
                return giftConfig.giftName;
            }
        }
        return "Unknown Gift";
    }
}
