package bai_tap;
import java.text.DecimalFormat;
import java.util.Scanner;

public class tinh_tien_grab {
	public static void main(String[] args) {
		
		int luaChon;
		double soKM, thoiGianCho ;
		
		Scanner banPhim = new Scanner(System.in);
				
		System.out.println("Vui lòng chọn dịch vụ");
		System.out.println("1. GrabCar");
		System.out.println("2. GrabSUV");
		System.out.println("3. GrabBlack");
		
		// Nhập lựa chọn
		do {
			System.out.print("Lựa chọn: ");
			luaChon = banPhim.nextInt();
			if (luaChon < 1 || luaChon > 3) {
				System.out.println("Lựa chọn của bạn không hợp lệ. Vui lòng nhập lại!");
			}
		} while (luaChon < 1 || luaChon > 3);
		
		// Nhập số km đi được
		do {
			System.out.print("Vui lòng nhập vào số km đi được: ");
			soKM = banPhim.nextDouble();
			if (soKM <= 0) {
				System.out.println("Số km đi được phải lớn hơn 0. Vui lòng nhập lại!");
			}
		} while (soKM <= 0);
		
		// Nhập thời gian chờ
		do {
			System.out.print("Vui lòng nhập thời gian chờ: " );
			thoiGianCho = banPhim.nextDouble();
			if (thoiGianCho <= 0) {
				System.out.println("Thời gian chờ phải lớn hơn 0. Vui lòng nhập lại!");
			}
		} while (thoiGianCho <= 0);
		
		banPhim.close();
				
		luaChonDichVu(luaChon,soKM,thoiGianCho);
	}
	public static void luaChonDichVu(int luaChon, double soKM, double thoiGianCho) {
		switch (luaChon) {
		case 1:
			grabCar(soKM, thoiGianCho);
			break;
		case 2:
			grabSUV(soKM, thoiGianCho);
			break;
		case 3:
			grabBlack(soKM, thoiGianCho);
			break;
		default:
			break;
		}
	}
	public static void grabCar(double soKM, double thoiGianCho) {
				
		// Khai báo số tiền dựa trên số km
		final int giaDauTien = 8000;
		final int gia1Den19 = 7500;
		final int giaTu19TroLen = 7000;
		double tienGrab = 0;
		
		// Khai báo mức phí thời gian chờ
		final int phiThoiGianCho = 2000;
		final int mocThoiGian = 3;
		double quyDoiThoiGian = 0;
		double tienThoiGianCho = 0;
				
		// Số km đi được * giá km đầu tiên
		if(soKM <= 1) {
			tienGrab = soKM * giaDauTien;
		}
		// Giá km đầu tiên + giá từ 1 đến 19 * (số km đi được - 1)
		if(soKM > 1 && soKM <= 19) {
			tienGrab = giaDauTien + gia1Den19 * (soKM - 1);
		}
		// Giá km đầu tiên + (giá từ 1 đến 19 * 18) + Giá 19 trở lên * (số km đi được - 19)
		if(soKM > 19) {
			tienGrab = giaDauTien + (gia1Den19 * 18) + (giaTu19TroLen * (soKM - 19));
		}
		// Tính phí thời gian chờ	
		if (thoiGianCho > mocThoiGian) {
			quyDoiThoiGian = (thoiGianCho - mocThoiGian) / 3;
			tienThoiGianCho = quyDoiThoiGian * phiThoiGianCho;
		}
		// Tiền km đi được + Tiền thời gian chờ
		double thanhTien = tienGrab + tienThoiGianCho;
		
		// định dạng chữ số thập phân tiền Grab
		DecimalFormat dinhDangTienGrab = new DecimalFormat("#,##0");
		String dinhDangGrab = dinhDangTienGrab.format(tienGrab);
		
		// định dạng chữ số thập phân tiền thời gian chờ
		DecimalFormat dinhDangTienThoiGianCho = new DecimalFormat("#,##0");
		String dinhDangThoiGianCho = dinhDangTienThoiGianCho.format(tienThoiGianCho);
		
		// định dạng chữ số thập phân Tổng tiền
		DecimalFormat dinhDangThanhTien = new DecimalFormat("#,##0");
		String dinhDangTien = dinhDangThanhTien.format(thanhTien);
		        
		System.out.println("****** Hóa Đơn Tiền Grab ******");
		System.out.println("Tổng số km đi được: " + soKM + "km - Thành tiền: " + dinhDangGrab + "đ");
		System.out.println("Thời gian chờ: " + thoiGianCho + " phút - Thành Tiền " + dinhDangThoiGianCho + "đ");
		System.out.print("Tổng Tiền: " +  dinhDangTien + "đ");
	}
	public static void grabSUV(double soKM, double thoiGianCho) {
		
		// Khai báo số tiền dựa trên số km
		final int giaDauTien = 9000;
		final int gia1Den19 = 8500;
		final int giaTu19TroLen = 8000;
		double tienGrab = 0;
		
		// Khai báo mức phí thời gian chờ
		final int phiThoiGianCho = 2000;
		final int mocThoiGian = 3;
		double quyDoiThoiGian = 0;
		double tienThoiGianCho = 0;
				
		// Số km đi được * giá km đầu tiên
		if(soKM <= 1) {
			tienGrab = soKM * giaDauTien;
		}
		// Giá km đầu tiên + giá từ 1 đến 19 * (số km đi được - 1)
		if(soKM > 1 && soKM <= 19) {
			tienGrab = giaDauTien + gia1Den19 * (soKM - 1);
		}
		// Giá km đầu tiên + (giá từ 1 đến 19 * 18) + Giá 19 trở lên * (số km đi được - 19)
		if(soKM > 19) {
			tienGrab = giaDauTien + (gia1Den19 * 18) + (giaTu19TroLen * (soKM - 19));
		}
				
		if (thoiGianCho > mocThoiGian) {
			quyDoiThoiGian = (thoiGianCho - mocThoiGian) / 3;
			tienThoiGianCho = quyDoiThoiGian * phiThoiGianCho;
		}
		// Tiền km đi được + Tiền thời gian chờ
		double thanhTien = tienGrab + tienThoiGianCho;
		
		// định dạng chữ số thập phân tiền Grab
		DecimalFormat dinhDangTienGrab = new DecimalFormat("#,##0");
		String dinhDangGrab = dinhDangTienGrab.format(tienGrab);
		
		// định dạng chữ số thập phân tiền thời gian chờ
		DecimalFormat dinhDangTienThoiGianCho = new DecimalFormat("#,##0");
		String dinhDangThoiGianCho = dinhDangTienThoiGianCho.format(tienThoiGianCho);
		
		// định dạng chữ số thập phân Tổng tiền
		DecimalFormat dinhDangThanhTien = new DecimalFormat("#,##0");
		String dinhDangTien = dinhDangThanhTien.format(thanhTien);
		        
		System.out.println("****** Hóa Đơn Tiền Grab ******");
		System.out.println("Tổng số km đi được: " + soKM + "km - Thành tiền: " + dinhDangGrab + "đ");
		System.out.println("Thời gian chờ: " + thoiGianCho + " phút - Thành Tiền " + dinhDangThoiGianCho + "đ");
		System.out.print("Tổng Tiền: " +  dinhDangTien + "đ");
	}
	public static void grabBlack(double soKM, double thoiGianCho) {
		
		// Khai báo số tiền dựa trên số km
		final int giaDauTien = 10000;
		final int gia1Den19 = 9500;
		final int giaTu19TroLen = 9000;
		double tienGrab = 0;
		
		// Khai báo mức phí thời gian chờ
		final int phiThoiGianCho = 2000;
		final int mocThoiGian = 3;
		double quyDoiThoiGian = 0;
		double tienThoiGianCho = 0;
				
		// Số km đi được * giá km đầu tiên
		if(soKM <= 1) {
			tienGrab = soKM * giaDauTien;
		}
		// Giá km đầu tiên + giá từ 1 đến 19 * (số km đi được - 1)
		if(soKM > 1 && soKM <= 19) {
			tienGrab = giaDauTien + gia1Den19 * (soKM - 1);
		}
		// Giá km đầu tiên + (giá từ 1 đến 19 * 18) + Giá 19 trở lên * (số km đi được - 19)
		if(soKM > 19) {
			tienGrab = giaDauTien + (gia1Den19 * 18) + (giaTu19TroLen * (soKM - 19));
		}
				
		if (thoiGianCho > mocThoiGian) {
			quyDoiThoiGian = (thoiGianCho - mocThoiGian) / 3;
			tienThoiGianCho = quyDoiThoiGian * phiThoiGianCho;
		}
		// Tiền km đi được + Tiền thời gian chờ
		double thanhTien = tienGrab + tienThoiGianCho;
		
		// định dạng chữ số thập phân tiền Grab
		DecimalFormat dinhDangTienGrab = new DecimalFormat("#,##0");
		String dinhDangGrab = dinhDangTienGrab.format(tienGrab);
		
		// định dạng chữ số thập phân tiền thời gian chờ
		DecimalFormat dinhDangTienThoiGianCho = new DecimalFormat("#,##0");
		String dinhDangThoiGianCho = dinhDangTienThoiGianCho.format(tienThoiGianCho);
		
		// định dạng chữ số thập phân Tổng tiền
		DecimalFormat dinhDangThanhTien = new DecimalFormat("#,##0");
		String dinhDangTien = dinhDangThanhTien.format(thanhTien);
		        
		System.out.println("****** Hóa Đơn Tiền Grab ******");
		System.out.println("Tổng số km đi được: " + soKM + "km - Thành tiền: " + dinhDangGrab + "đ");
		System.out.println("Thời gian chờ: " + thoiGianCho + " phút - Thành Tiền " + dinhDangThoiGianCho + "đ");
		System.out.print("Tổng Tiền: " +  dinhDangTien + "đ");
	}	
}