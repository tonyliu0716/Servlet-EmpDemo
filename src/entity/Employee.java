package entity;
//实体类，员工的属性与表nerdluv.singles中的字段匹配,表中有几列，类中就有几个属性
public class Employee {
	
	private int id;
	private String name;
	private String pass;
	private String gender;
	private int age;
	private String type1;
	private String type2;
	private String type3;
	private String type4;
	private String os;
	private int min;
	private int max;
	
	//自动生成两个构造方法：有参数和无参数
	public Employee(int id, String name, String pass, String gender, int age,
			String type1, String type2, String type3, String type4, String os,
			int min, int max) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.gender = gender;
		this.age = age;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.type4 = type4;
		this.os = os;
		this.min = min;
		this.max = max;
	}
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	//自动生成get set 方法
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getType4() {
		return type4;
	}
	public void setType4(String type4) {
		this.type4 = type4;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}

	//重写toString
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", pass=" + pass
				+ ", gender=" + gender + ", age=" + age + ", type1=" + type1
				+ ", type2=" + type2 + ", type3=" + type3 + ", type4=" + type4
				+ ", os=" + os + ", min=" + min + ", max=" + max + "]";
	}
	
}
