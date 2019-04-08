package complexeNumber;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Model de donnée servant à implémenter la liste et la comboBox
 * Implemente les interfaces ListModel, Observer et ComboBoxModel
 * @author e1604902 Samuel LE BERRE -- OCTOBER 2018
 * @version 1.0
 */
public class AlgorithmListModel implements ListModel, Observer, ComboBoxModel{

    /**
     * Le premier nombre complexe
     */
    private ComplexNumber cn1;
    /**
     * Le second nombre complexe
     */
    private ComplexNumber cn2;
    /**
     * Le troisieme nombre complexe qui est l addition des 2 premiers
     */
    private ComplexNumber cnSum;
    /**
     * Le nombre complexe selectionné dans la comboBox
     */
    private ComplexNumber cnSelected;
    /**
     * La liste des listeners des données
     */
    private ArrayList<ListDataListener> list;
    
    /**
     * Constructeur de la classe
     * @param cn1 le premier nombre complexe
     * @param cn2 le second nombre complexe
     * @param cnSum le nombre complex qui est la somme des deux premier
     */
    public AlgorithmListModel(ComplexNumber cn1, ComplexNumber cn2, ComplexNumber cnSum){
        this.list = new ArrayList<ListDataListener>();
        this.cn1 = cn1;
        this.cn2 = cn2;
        this.cnSum = cnSum;
        cn1.addObserver(this);
        cn2.addObserver(this);
        this.setSelectedItem(cn1);
    }
    
    /**
     * Donne le nombre d élément dans la liste
     * @return Le nombre de nombre complexe
     */
    @Override
    public int getSize() {
        return 3 ;
    }

    /**
     * Retourn l'élément à l'indice donné
     * @param i L'indice
     * @return L'élément à l'indice donné
     */
    @Override
    public Object getElementAt(int i) {
        switch (i) {
            case 0:
                return cn1;
            case 1:
                return cn2;
            case 2:
                return cnSum;
            default:
                return null;
        }
    }

    /**
     * Ajoute une ListDataListener a la liste des ListDataListener
     * @param ll la ListDataListener à ajouter
     */
    @Override
    public void addListDataListener(ListDataListener ll) {
        this.list.add(ll);
    }

    /**
     * Supprime une ListDataListener de la liste des ListDataListener
     * @param ll La ListDataListener à supprimer
     */
    @Override
    public void removeListDataListener(ListDataListener ll) {
        this.list.remove(ll);;
    }
    
    /**
     * Met à jour le nombre complex et en notifie la liste
     * @param o L'observable qui à lancer la mise à jour
     * @param o1 Un objet
     */
    @Override
    public void update(Observable o, Object o1) {
        for(ListDataListener ldl : this.list){
            cnSum = cn1.add(cn2);
            ListDataEvent event = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED,0,2);
            ldl.contentsChanged(event); 
        }
    }
    
    /**
     * Affecte l'object sélectionne dans la comboBox à cnSelected
     * @param o L'object sélectionné
     */
    @Override
    public void setSelectedItem(Object o) {
        if(o instanceof ComplexNumber){
            this.cnSelected = (ComplexNumber) o;
        }
    }

    /**
     * Retourn l'objet sélectionné dans la comboBox
     * @return L'élément sélectionné
     */
    @Override
    public Object getSelectedItem() {
        return this.cnSelected;
    }
}
