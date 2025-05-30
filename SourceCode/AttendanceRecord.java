package SourceCode;

// AttendanceRecord.java
// Lưu một bản ghi chấm công: mã nhân viên và ngày
public class AttendanceRecord {
    public String empId;
    public String date; // lưu dạng chuỗi yyyy-MM-dd
    public AttendanceRecord(String empId, String date) {
        this.empId = empId;
        this.date = date;
    }
}
