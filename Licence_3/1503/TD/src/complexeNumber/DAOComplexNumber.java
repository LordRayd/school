package complexeNumber;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author e1604902
 */
public abstract class DAOComplexNumber {

    protected HashMap<UUID,ComplexNumber> list;

    final public void save(ComplexNumber complexNumber) throws IOException{
        if(complexNumber == null) {
            throw new NullPointerException("complexNumber == null");
        }
        writeToPersistence(complexNumber);
        this.list.put(complexNumber.getId(), complexNumber);
    }

    public abstract void writeToPersistence(ComplexNumber complexNumber);

    final public ComplexNumber find(UUID uuid) throws IOException{
        ComplexNumber founded = this.list.get(uuid);
        if(founded==null) {
            founded = loadFromPersistence(uuid);
            if(founded != null) {
                this.list.put(founded.getId(),founded);
            }
        }
        return founded;
    }
    
    public abstract ComplexNumber loadFromPersistence(UUID uuid);

    final public void delete(ComplexNumber complexNumber) throws IOException {
        UUID uuid = complexNumber.getId();
        this.list.remove(uuid);
        deleteInPersistence(uuid);
    }

    final public void delete(UUID uuid) throws IOException{
        this.list.remove(uuid);
        deleteInPersistence(uuid);
    }

    public abstract void deleteInPersistence(UUID uuid) throws IOException;

}