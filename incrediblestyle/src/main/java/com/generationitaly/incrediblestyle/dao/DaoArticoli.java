package com.generationitaly.incrediblestyle.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.generationitaly.incrediblestyle.model.Articolo;
import com.generationitaly.incrediblestyle.model.Categoria;

/**
 * Questa classe si occupata della connessione con il DataBase
 */
@Repository
public class DaoArticoli implements IDaoArticoli {

    private String dbAddress;
    private String username;
    private String password;

    /**
     * @param dbAddress
     * @param username
     * @param password
     */
    public DaoArticoli(@Value("${db.address}") String dbAddress, @Value("${db.user}") String username,
            @Value("${db.psw}") String password) {
        this.dbAddress = dbAddress;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<Articolo> listaArticoli() {
        List<Articolo> listaArticoli = new ArrayList<Articolo>();
        try (Connection conn = DriverManager.getConnection(dbAddress, username, password)) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM articoli INNER JOIN categorie ON articoli.id_categoria = categorie.id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaArticoli.add(
                        new Articolo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
                                rs.getString(6), rs.getInt(7), rs.getString(8),
                                new Categoria(rs.getInt(9), rs.getString(10))));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaArticoli;
    }

    @Override
    public Articolo articolo(int codiceArticolo) {
        Articolo a = null;
        try (Connection conn = DriverManager.getConnection(dbAddress, username, password)) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM articoli INNER JOIN categorie ON articoli.id_categoria = categorie.id WHERE codiceArticolo =?");
            ps.setInt(1, codiceArticolo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a = new Articolo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getString(8), new Categoria(rs.getInt(9), rs.getString(10)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean aggiungiArticolo(Articolo articolo) {
        PreparedStatement ps = null;

        try (Connection conn = DriverManager.getConnection(dbAddress, username, password)) {
            ps = conn.prepareStatement(
                    "INSERT INTO articoli (nome, foto, prezzo, colore, taglia, quantita, sesso, id_categoria ) values(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, articolo.getNome());
            ps.setString(2, articolo.getFoto());
            ps.setDouble(3, articolo.getPrezzo());
            ps.setString(4, articolo.getColore());
            ps.setString(5, articolo.getTaglia());
            ps.setInt(6, articolo.getQuantita());
            ps.setString(7, articolo.getSesso());
            ps.setInt(8, articolo.getCategoria().getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modificaArticolo(Articolo articolo) {
        try (Connection conn = DriverManager.getConnection(dbAddress, username, password)) {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE articoli SET nome=?, foto=?, prezzo=?, colore=?, taglia=?, quantita=?, sesso=?, id_categoria=? WHERE codiceArticolo = ?");
            ps.setString(1, articolo.getNome());
            ps.setString(2, articolo.getFoto());
            ps.setDouble(3, articolo.getPrezzo());
            ps.setString(4, articolo.getColore());
            ps.setString(5, articolo.getTaglia());
            ps.setInt(6, articolo.getQuantita());
            ps.setString(7, articolo.getSesso());
            ps.setInt(8, articolo.getCategoria().getId());
            ps.setInt(9, articolo.getCodiceArticolo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminaArticolo(int codiceArticolo) {
        try (Connection conn = DriverManager.getConnection(dbAddress, username, password)) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM articoli WHERE codiceArticolo=?");
            ps.setInt(1, codiceArticolo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
