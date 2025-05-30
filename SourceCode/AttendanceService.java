package SourceCode;

// AttendanceService.java
// Xử lý chấm công, chỉ dùng ArrayList để lưu
import java.util.ArrayList;
public class AttendanceService {
    private ArrayList<AttendanceRecord> records = new ArrayList<>();

    // Ghi nhận chấm công cho nhân viên vào ngày
    public void checkIn(String empId, String date) {
        // không kiểm tra trùng, giả sử user chỉ chấm 1 lần/ngày
        records.add(new AttendanceRecord(empId, date));
    }

    // Đếm số ngày đã chấm công
    public int getDaysAttended(String empId) {
        int count = 0;
        for (AttendanceRecord r : records) {
            if (r.empId.equals(empId)) {
                count++;
            }
        }
        return count;
    }
}
