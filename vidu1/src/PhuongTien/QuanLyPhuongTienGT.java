package PhuongTien;

import Pratice.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyPhuongTienGT {
    private ArrayList<Oto> listOto = new ArrayList<Oto>();
    private ArrayList<XeMay> listXeMay = new ArrayList<XeMay>();
    private ArrayList<XeTai> listXeTai = new ArrayList<XeTai>();

    public QuanLyPhuongTienGT() {
    }

    public void addOto(Oto oto){
        listOto.add(oto);
    }

    public void addXeMay(XeMay xeMay){
        listXeMay.add(xeMay);
    }

    public void addXeTai(XeTai xeTai){
        listXeTai.add(xeTai);
    }

    public void xuat(){
        for (Oto oto : listOto){
            oto.xuat();
        }
        for (XeMay xeMay : listXeMay){
            xeMay.xuat();
        }
        for (XeTai xeTai : listXeTai){
            xeTai.xuat();
        }
    }

    public void timKiemTheoHang(String HangSX){
        for (Oto oto : listOto){
            if (oto.getHangSX().equals(HangSX)){
                oto.xuat();
            }
        }
        for (XeMay xeMay : listXeMay){
            if (xeMay.getHangSX().equals(HangSX)){
                xeMay.xuat();
            }
        }
        for (XeTai xeTai : listXeTai){
            if (xeTai.getHangSX().equals(HangSX)){
                xeTai.xuat();
            }
        }
    }

    public void timKiemTheoMau(String Mau){
        for (Oto oto : listOto){
            if (oto.getMauXe() == Mau){
                oto.xuat();
            }
        }
        for (XeMay xeMay : listXeMay){
            if (xeMay.getMauXe() == Mau){
                xeMay.xuat();
            }
        }
        for (XeTai xeTai : listXeTai){
            if (xeTai.getMauXe() == Mau){
                xeTai.xuat();
            }
        }
    }

    public void sapXepTheoGiaOto(){
        Collections.sort(listOto, Comparator.comparingDouble(Oto::getGiaBan));
        for (Oto oto : listOto){
            oto.xuat();
        }
    }

    public void sapXepTheoGiaXeMay(){
        Collections.sort(listXeMay, Comparator.comparingDouble(XeMay::getGiaBan));
        for (XeMay xeMay : listXeMay){
            xeMay.xuat();
        }
    }

    public void sapXepTheoGiaXeTai(){
        Collections.sort(listXeTai, Comparator.comparingDouble(XeTai::getGiaBan));
        for (XeTai xeTai : listXeTai){
            xeTai.xuat();
        }
    }


}
