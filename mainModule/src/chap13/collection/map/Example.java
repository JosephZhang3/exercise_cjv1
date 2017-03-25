package chap13.collection.map;

public class Example {
	private String myid;
	private String myname;

	// source————>>generate constructor using fields
	public Example(String myid, String myname) {
		super();
		this.myid = myid;
		this.myname = myname;
	}

	// source————>>generate getters and setters
	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

}
