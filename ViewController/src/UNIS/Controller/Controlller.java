package UNIS.Controller;

import javax.faces.event.ActionEvent;

import UNIS.Dao.metodos;

import UNIS.Model.data;


import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.data.RichTable;


import org.apache.myfaces.trinidad.event.SelectionEvent;


public class Controlller {

    public Controlller() {
    }
    data d = new data();
    data row = new data();
    metodos dao;
    Integer id;
    List<data> lts_UNIS = new ArrayList();

    public void delete(ActionEvent actionEvent) throws Exception {
        dao = new metodos();
        dao.deleteUNIS(row);
        listar(actionEvent);
    }

    public void insert(ActionEvent actionEvent) throws Exception {
        dao = new metodos();
        dao.insertUNIS(d);
    }

    public void update(ActionEvent actionEvent) throws Exception {
        dao = new metodos();
        dao.updateUNIS(row);
        listar(actionEvent);
    }

    public void listar(ActionEvent actionEvent) throws Exception {
        dao = new metodos();
        lts_UNIS = dao.listaUNIS();
    }

    public void setLts_UNIS(List<data> lts_UNIS) {
        this.lts_UNIS = lts_UNIS;
    }

    public List<data> getLts_UNIS() {
        return lts_UNIS;
    }

    public data selecction(SelectionEvent selectionEvent) throws Exception {
        RichTable table = (RichTable)selectionEvent.getSource();
        row = (data)table.getSelectedRowData();
        System.out.println(row.getPersonNumber());
        return row;
    }

    public void setD(data d) {
        this.d = d;
    }

    public data getD() {
        return d;
    }

    public void setRow(data row) {
        this.row = row;
    }

    public data getRow() {
        return row;
    }
}
