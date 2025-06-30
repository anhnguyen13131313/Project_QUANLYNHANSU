package SourceCode;

// Lưu một bản ghi chấm công, mã nhân viên và ngày chấm công
public class AttendanceRecord {
    public String empId;
    public String date; // date ở đây có dạng năm tháng ngày
    public AttendanceRecord(String empId, String date) {
        this.empId = empId;
        this.date = date;
    }
}
