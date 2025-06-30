package SourceCode;
// Department.java
// Lưu thông tin phòng ban
public class Department {
    private String id;          // mã của phòng ban ạ, ví dụ như là A001
    private String name;        // Tên của phòng ban
    private String description; // Mô tả ngắn về phòng ban

    public Department(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Phương thức lấy thông tin (getter)
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    // Phương thức cập nhật (setter)
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
}