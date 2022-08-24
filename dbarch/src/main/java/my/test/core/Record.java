package my.test.core;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Lob;
import javax.persistence.Column;

import java.util.Objects;

import org.hibernate.annotations.RowId;

@Entity
@Table(name = "MEDIA_FILE")
@RowId("ROWID")
public class Record {
	
	@Id
	@Column(name = "PART_NAME")
	private String partname;
	
	@Column(name = "MEDCODE")
	private String medcode;
	
	@Column(name = "BIN")
	@Lob
	private byte[] bin;

	public byte[] getBin() { return bin; }
	public void setBin(byte[] bin) { this.bin = bin; }

	public String getPartname() { return this.partname; }
	public void setPartname(String partname) { this.partname = partname; }

	public String getMedcode() { return this.medcode; }
	public void setMedcode(String medcode) { this.medcode = medcode; }

	public int getSize(){ return bin.length; }

	@Override
	public int hashCode() {
		return Objects.hash(medcode, partname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Record other = (Record) obj;
		return Objects.equals(medcode, other.medcode) && Objects.equals(partname, other.partname);
	}

}
