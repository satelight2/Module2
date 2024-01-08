package ChuyenXe;

import java.util.Arrays;

public class QuanlyChuyenXe {
    private NgoaiThanh[] ngoaiThanhs;
    private NoiThanh[] noiThanhs;
    private int indexNoi = 0;
    private int indexNgoai = 0;
    private int defaultElement = 10;

    public QuanlyChuyenXe()
    {
        this.noiThanhs = new NoiThanh[defaultElement];
        this.ngoaiThanhs = new NgoaiThanh[defaultElement];
    }



    public void addNgoaiThanh()
    {
        NgoaiThanh ngoaiThanh = new NgoaiThanh();
        ngoaiThanh.nhap();
        if(indexNgoai == defaultElement)
        {
            ngoaiThanhs = Arrays.copyOf(ngoaiThanhs, defaultElement*2);
        }else {
            ngoaiThanhs[indexNgoai] = ngoaiThanh;
            indexNgoai++;
            System.out.println("Thêm thành công");
        }
    }

    public void addNoiThanh()
    {
        NoiThanh noiThanh = new NoiThanh();
        noiThanh.nhap();
        if(indexNoi == defaultElement)
        {
            noiThanhs = Arrays.copyOf(noiThanhs, defaultElement*2);
        }else {
            noiThanhs[indexNoi] = noiThanh;
            indexNoi++;
        }
    }
    public void hienThiNoiThanh()
    {
        System.out.printf("%5s | %15s | %10s | %10s | %15s | %15s |\n","Mã Chuyến xe","Tên chuyến xe","Số Chuyến xe","Doanh Thu","Số km","Số tuyến");
        for (int i = 0; i < indexNoi; i++) {
            System.out.printf("%5s | %15s | %10s | %10s | %15s | %15s |\n",noiThanhs[i].getMacx(),noiThanhs[i].getNameTX(),noiThanhs[i].getSoX(),noiThanhs[i].getDoanhThu(),noiThanhs[i].getSoKm(),noiThanhs[i].getSoTuyen());
        }
    }

    public void hienThiNgoaiThanh()
    {
        System.out.printf("%5s | %15s | %10s | %10s | %15s | %15s |\n","Mã Chuyến xe","Tên chuyến xe","Số Chuyến xe","Doanh Thu","Nơi đến","Số ngày đi");
        for (int i = 0; i < indexNgoai; i++) {
            System.out.printf("%5s | %15s | %10s | %10s | %15s | %15s |\n",ngoaiThanhs[i].getMacx(),ngoaiThanhs[i].getNameTX(),ngoaiThanhs[i].getSoX(),ngoaiThanhs[i].getDoanhThu(),ngoaiThanhs[i].getNoiDen(),ngoaiThanhs[i].getSoNgay());
        }
    }

    public void xoaNoiThanh(String maCX)
    {
        for (int i = 0; i < indexNoi; i++) {
            if(noiThanhs[i].getMacx().equals(maCX))
            {
                for (int j = i; j < indexNoi-1; j++) {
                    noiThanhs[j] = noiThanhs[j+1];
                }
                indexNoi--;
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy mã chuyến xe");
    }

    public void xoaNgoaiThanh(String maCX)
    {
        for (int i = 0; i < indexNgoai; i++) {
            if(ngoaiThanhs[i].getMacx().equals(maCX))
            {
                for (int j = i; j < indexNgoai-1; j++) {
                    ngoaiThanhs[j] = ngoaiThanhs[j+1];
                }
                indexNgoai--;
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy mã chuyến xe");
    }

    public void suaNoiThanh(String maCX)
    {
        for (int i = 0; i < indexNoi; i++) {
            if(noiThanhs[i].getMacx().equals(maCX))
            {
                noiThanhs[i].nhap();
                System.out.println("Sửa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy mã chuyến xe");
    }

    public void suaNgoaiThanh(String maCX)
    {
        for (int i = 0; i < indexNgoai; i++) {
            if(ngoaiThanhs[i].getMacx().equals(maCX))
            {
                ngoaiThanhs[i].nhap();
                System.out.println("Sửa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy mã chuyến xe");
    }
}
