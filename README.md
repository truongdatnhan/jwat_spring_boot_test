# Xây dựng api cho ứng dụng đặt vé xem phim bằng Java Srping Boot
## Mô tả dự án
- Xây dựng API cho ứng dụng đặt vé xem phim
- Sử dụng: Java Spring Boot & MySQL & JWT

## Các chức năng chính của hệ thống

- Đăng kí, đăng nhập, nhập thông tin User
- Book vé, chọn phim từ danh sách ...

## Thực hiện cài đặt
//
## Các lỗi gặp phải nếu có
//
### Lỗi bị chiếm port và không chạy được
- Cách sửa: thay đổi port trong file `application.properties`
    >`server.port=80`
### Không kết nối được đến CSDL
- Cách fix lỗi: sử dụng `database.sql` import vào phpmyadmin và cấu hình lại kết nối trong file `application.properties`
