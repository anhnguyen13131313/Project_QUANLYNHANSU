package SourceCode;
// Department.java
// Lưu thông tin phòng ban
public class Department {
    private String id;          // Mã phòng ban, ví dụ "D001"
    private String name;        // Tên phòng ban
    private String description; // Mô tả ngắn

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