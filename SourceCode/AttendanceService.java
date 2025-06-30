package SourceCode;

// xử lý chức năng chấm công, dùng ArrayList để lưu
import java.util.ArrayList;
public class AttendanceService {
    private ArrayList<AttendanceRecord> records = new ArrayList<>();

    // Ghi nhận chấm công cho nhân viên vào ngày date
    public void checkIn(String empId, String date) {
        // không kiểm tra trùng, giả sử nhân viên chỉ chấm công 1 lần mỗi ngày
        records.add(new AttendanceRecord(empId, date));
    }

    // Đếm số ngày mà nhân viên  đã chấm công
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
