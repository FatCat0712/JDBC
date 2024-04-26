1 Prepared Statement là gì ?

Prepared Statement ( còn được gọi là câu lệnh được tham số hóa) chỉ đơn giản là một câu truy vấn SQL có chứa các tham số giữ chỗ thay vì các giá trị thực tế.

Các tham số này sẽ được thay thế bằng các giá trị thực tế tại thời điểm thực hiện câu lệnh.

Ví dụ

INSERT INTO customer (first_name, last_name, email) VALUES(?,?,?);

Việc thực hiện Prepared Statement bao gồm 2 giai đoạn: chuẩn bị và thực thi

* Chuẩn bị: ở giai đoạn chuẩn bị, một mẫu câu lệnh SQL được tạo và gửi đến máy chủ CSDL. Máy chủ phân tích mẫu câu lệnh, thực hiện kiểm tra cú pháp và tối ưu hóa truy vấn và lưu trữ để sử dụng sau.

* Thực thi: trong quá trình thực thi, các giá trị tham số được gửi đến máy chủ. Máy chủ tạo một câu lệnh từ mẫu câu lệnh và sử dụng các giá trị để thực thi nó.

2 Ưu điểm của việc sử dụng Prepared Statement

+ Có thể thực hiện cùng một câu lệnh lặp đi lặp lại với hiệu quả cao, bởi vì câu lệnh chỉ được phân tích cú pháp một lần, trong khi nó có thể được thực thi nhiều lần. 

+ Nó cũng giảm thiểu việc sử dụng băng thông, vì mỗi lần thực thi, chỉ có các giá trị giữ chỗ cần được truyền đến máy chủ CSDL thay vì truyền cả câu lệnh SQL hoàn chỉnh.

+ Prepared Statement cũng cung cấp sự bảo vệ mạnh mẽ chống SQL injection( hành động cố gắng truyền câu lệnh SQL để thao túng CSDL), bởi vì các giá trị tham số không được nhúng trực tiếp bên trong chuỗi truy vấn SQL.

+ Các giá trị tham số được gửi đến máy chủ CSDL tách biệt với truy vấn bằng một giao thức khác và do đó không thể can thiệp vào nó.

+ Máy chủ sử dụng các giá trị này trực tiếp tại thời điểm thực hiện, sau khi mẫu câu lệnh được phân tích cú pháp.

+ Đó là lý do tạo sao các Prepared Statement ít bị lỗi hơn và do đó được coi là một trong những yếu tố quan trọng nhất trong bảo mật cơ sở dữ liệu
