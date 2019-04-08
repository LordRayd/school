/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexeNumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e1604902
 */
public class RandomAccessFileDAOComplexNumber extends DAOComplexNumber{

    private final String DIRECTORY;
    private static File file;
    private static int lengthOfEachCN;
    
    RandomAccessFileDAOComplexNumber(String filename){
        this.DIRECTORY = filename;
        this.list = new HashMap<UUID,ComplexNumber>();
        this.file = new File(this.DIRECTORY + "RandomAccessFileDAO.dao");
        this.lengthOfEachCN = Byte.BYTES + Double.BYTES*2;
    }
    
    @Override
    public void writeToPersistence(ComplexNumber complexNumber) {
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile(this.file,"write");
            raf.seek(complexNumber.getId().getLeastSignificantBits() * this.lengthOfEachCN);
            if(complexNumber instanceof CartesianComplexNumber){
                raf.writeByte(0);
                raf.writeDouble(complexNumber.getReal());
                raf.writeDouble(complexNumber.getImaginary());
            }else{
                raf.writeByte(1);
                raf.writeDouble(complexNumber.getModulus());
                raf.writeDouble(complexNumber.getArgument());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomAccessFileDAOComplexNumber.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomAccessFileDAOComplexNumber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ComplexNumber loadFromPersistence(UUID uuid) {
        ComplexNumber complexNumber = null;
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile(this.file,"read");
            raf.seek(uuid.getLeastSignificantBits() * this.lengthOfEachCN);
            if(raf.readByte()== 0 ){
                complexNumber = new CartesianComplexNumber(raf.readDouble(),raf.readDouble());
            }else{
                complexNumber = new PolarComplexNumber(raf.readDouble(),raf.readDouble());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomAccessFileDAOComplexNumber.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomAccessFileDAOComplexNumber.class.getName()).log(Level.SEVERE, null, ex);
        }
        return complexNumber;
    }

    @Override
    public void deleteInPersistence(UUID uuid) throws IOException {
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile(this.file,"write");
            raf.seek(uuid.getLeastSignificantBits() * this.lengthOfEachCN);
            raf.writeByte(0);
            raf.writeDouble(0);
            raf.writeDouble(0);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomAccessFileDAOComplexNumber.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomAccessFileDAOComplexNumber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}