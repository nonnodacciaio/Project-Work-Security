package com.generationitaly.incrediblestyle.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.generationitaly.incrediblestyle.model.Categoria;

@Repository
public class DaoCategorie implements IDaoCategorie {

    private String dbAddress;
    private String username;
    private String password;

    public DaoCategorie(@Value("${db.address}") String dbAddress, @Value("${db.user}") String username,
            @Value("${db.psw}") String password) {
        this.dbAddress = dbAddress;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<Categoria> listaCategorie() {
        List<Categoria> listaCategorie = new ArrayList<Categoria>();
        try (Connection conn = DriverManager.getConnection(dbAddress, username, password)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM categorie");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaCategorie.add(new Categoria(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaCategorie;
    }

    @Override
    public Categoria categoria(int id) {
        Categoria c = null;
        try (Connection conn = DriverManager.getConnection(dbAddress, username, password)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM categorie WHERE id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Categoria(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public boolean aggiungiCategoria(Categoria categoria) {
        PreparedStatement ps = null;

        try (Connection conn = DriverManager.getConnection(dbAddress, username, password)) {
            ps = conn.prepareStatement("INSERT INTO categorie(tipo) VALUES (?)");
            ps.setString(1, categoria.getTipo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modificaCategoria(Categoria categoria) {
        try (Connection conn = DriverManager.getConnection(dbAddress, username, password)) {
            PreparedStatement ps = conn.prepareStatement("UPDATE categorie set tipo=? WHERE id=?");
            ps.setString(1, categoria.getTipo());
            ps.setInt(2, categoria.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminaCategoria(int id) {
        try (Connection conn = DriverManager.getConnection(dbAddress, username, password)) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM categorie WHERE id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
