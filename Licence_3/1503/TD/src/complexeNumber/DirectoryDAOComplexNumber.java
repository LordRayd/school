package complexeNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author e1604902
 */
public class DirectoryDAOComplexNumber extends DAOComplexNumber{

    private final static String PREFIXE_FILE = "CN";
    private final static String CARTESIAN_TYPE = "cartesian";
    private final static String POLAR_TYPE = "polar";
    private final static String ENCODAGE = "utf8";
    private final String DIRECTORY;

    DirectoryDAOComplexNumber(String filename){
        this.DIRECTORY = filename;
        this.list = new HashMap<UUID,ComplexNumber>();
    }

    @Override
    public void writeToPersistence(ComplexNumber complexNumber) {
      FileOutputStream fos;
      BufferedWriter bfW;
        try{
            fos = new FileOutputStream(DIRECTORY + PREFIXE_FILE + complexNumber.getId());
            bfW = new BufferedWriter(new OutputStreamWriter(fos, ENCODAGE));

            bfW.write(this.PREFIXE_FILE+"\n");
            if (complexNumber instanceof CartesianComplexNumber) {
                bfW.write(this.CARTESIAN_TYPE + "\n");
                bfW.write(complexNumber.getReal() + "\n");
                bfW.write(complexNumber.getImaginary() + "\n");
            }else if (complexNumber instanceof PolarComplexNumber) {
                bfW.write(this.POLAR_TYPE + "\n");
                bfW.write(complexNumber.getModulus() + "\n");
                bfW.write(complexNumber.getArgument() + "\n");
            }
            bfW.close();
        }catch(Exception e){

        }finally{

        }
    }

    @Override
    public ComplexNumber loadFromPersistence(UUID uuid){
        FileInputStream fis;
        BufferedReader bfR = null;
        ComplexNumber ret = null;
        try {
            fis = new FileInputStream(DIRECTORY + PREFIXE_FILE + uuid);
            bfR = new BufferedReader(new InputStreamReader(fis, ENCODAGE));

            if(this.CARTESIAN_TYPE.equals(bfR.readLine())){
                ret = new CartesianComplexNumber( Double.parseDouble(bfR.readLine()), Double.parseDouble(bfR.readLine()) );
            }else{
                ret = new PolarComplexNumber( Double.parseDouble(bfR.readLine()), Double.parseDouble(bfR.readLine()) );
            }
            bfR.close();
        }catch(IOException ioe){

        }
        return ret;
    }

    @Override
    public void deleteInPersistence(UUID uuid) throws IOException {
        try{
            File file = new File(this.DIRECTORY + this.PREFIXE_FILE + uuid);
            if(file.delete()){
                System.out.println(file.getName() + " is deleted!");
            }else{
         System.out.println("Delete operation is failed.");
            }
      }catch(Exception e){
            e.printStackTrace();
      }
    }
}