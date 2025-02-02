package edu.vt.EntityBeans;

import edu.vt.globals.Constants;

import java.io.Serial;
import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// The @Entity annotation designates this class as a Jakarta Persistence Entity POJO class representing the database table UserFile.
@Entity

// Name of the database table represented
@Table(name = "UserFile")

@NamedQueries({
    /*
    private User userId;    --> userId is the object reference of the User object.
    userId.id               --> User object's database primary key
     */
    @NamedQuery(name = "UserFile.findAll", query = "SELECT u FROM UserFile u")
    , @NamedQuery(name = "UserFile.findById", query = "SELECT u FROM UserFile u WHERE u.id = :id")
    , @NamedQuery(name = "UserFile.findByFilename", query = "SELECT u FROM UserFile u WHERE u.filename = :filename")
})

public class UserFile implements Serializable {
    /*
    ========================================================
    Instance variables representing the attributes (columns)
    of the database table UserFile.

    CREATE TABLE UserFile
    (
        id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
        filename VARCHAR(255) NOT NULL,
        user_id INT UNSIGNED NOT NULL,
        FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
    );
    ========================================================
     */
    @Serial
    private static final long serialVersionUID = 1L;

    // id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    // filename VARCHAR(255) NOT NULL
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "filename")
    private String filename;

    /*
    =========================================================
    Class constructors for instantiating a UserFile entity
    object to represent a row in the database table UserFile.
    =========================================================
     */
    public UserFile() {
    }

    // Used in handleFileUpload() method of FileUploadManager
    public UserFile(String filename) {
        this.filename = filename;
    }

    /*
    ======================================================
    Getter and Setter methods for the attributes (columns)
    of the database table UserFile.
    ======================================================
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /*
    ===============
    Instance Method
    ===============
     */
    public String getFilePath() {
        return Constants.FILES_ABSOLUTE_PATH + getFilename();
    }

    /*
    ================================
    Instance Methods Used Internally
    ================================
     */

    // Generate and return a hash code value for the object with database primary key id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /*
     Checks if the UserFile object identified by 'object' is the same as the UserFile object identified by 'id'
     Parameter object = UserFile object identified by 'object'
     Returns True if the UserFile 'object' and 'id' are the same; otherwise, return False
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UserFile other)) {
            return false;
        }
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    // Return String representation of database primary key id
    @Override
    public String toString() {
        return id.toString();
    }

}
