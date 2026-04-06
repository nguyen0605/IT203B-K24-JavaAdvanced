package btgioii4;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public List<BenhNhanDTO> getDashboardData() {
    List<BenhNhanDTO> result = new ArrayList<>();
    Map<Integer, BenhNhanDTO> map = new HashMap<>();

    String sql = """
        SELECT bn.maBenhNhan, bn.ten,
               dv.maDichVu, dv.tenDichVu
        FROM BenhNhan bn
        LEFT JOIN DichVuSuDung dv 
        ON bn.maBenhNhan = dv.maBenhNhan
    """;

    try (Connection conn = DatabaseManager.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            int maBN = rs.getInt("maBenhNhan");

            // Nếu chưa có bệnh nhân → tạo mới
            BenhNhanDTO bn = map.get(maBN);
            if (bn == null) {
                bn = new BenhNhanDTO();
                bn.setMaBenhNhan(maBN);
                bn.setTen(rs.getString("ten"));
                bn.setDsDichVu(new ArrayList<>());

                map.put(maBN, bn);
            }

            // =========================
            // 🚨 BẪY 2: NULL dịch vụ
            // =========================
            int maDV = rs.getInt("maDichVu");

            if (!rs.wasNull()) {
                DichVu dv = new DichVu();
                dv.setMaDichVu(maDV);
                dv.setTenDichVu(rs.getString("tenDichVu"));

                bn.getDsDichVu().add(dv);
            }
            // Nếu NULL → vẫn giữ bệnh nhân (LEFT JOIN xử lý)
        }

        result.addAll(map.values());

    } catch (Exception e) {
        e.printStackTrace();
    }

    return result;
}
