package fr.milekat.cite_core.core.utils;

import fr.milekat.cite_core.MainCore;
import fr.milekat.cite_libs.MainLibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class EventPoints {
    public static void addPoint(UUID playeruuid, Integer points) throws SQLException {
        Connection connection = MainLibs.getSql();
        PreparedStatement q = connection.prepareStatement("UPDATE `" + MainCore.SQLPREFIX +
                "player` SET `points_event` = `points_event` + ? WHERE `uuid` = ?;");
        q.setInt(1, points);
        q.setString(2, playeruuid.toString());
        q.execute();
        q.close();
    }

    public static void removePoint(UUID playeruuid, Integer points) throws SQLException {
        Connection connection = MainLibs.getSql();
        PreparedStatement q = connection.prepareStatement("UPDATE `" + MainCore.SQLPREFIX +
                "player` SET `points_event` = `points_event` - ? WHERE `uuid` = ?;");
        q.setInt(1, points);
        q.setString(2, playeruuid.toString());
        q.execute();
        q.close();
    }

    public static void setPoint(UUID playeruuid, Integer points) throws SQLException {
        Connection connection = MainLibs.getSql();
        PreparedStatement q = connection.prepareStatement("UPDATE `" + MainCore.SQLPREFIX +
                "player` SET `points_event` = ? WHERE `uuid` = ?;");
        q.setInt(1, points);
        q.setString(2, playeruuid.toString());
        q.execute();
        q.close();
    }
}
