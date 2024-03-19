package pt.ipp.isep.dei.esoft.project.exceptions;

public class DataExistsException extends Throwable {

    public DataExistsException (String name) throws Exception {
        throw new Exception(name + " already exists");
    }
}
