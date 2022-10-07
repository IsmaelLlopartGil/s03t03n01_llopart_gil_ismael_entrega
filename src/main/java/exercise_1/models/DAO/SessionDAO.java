package exercise_1.models.DAO;

import exercise_1.models.Session;

public abstract class SessionDAO {
	
    protected Session session;
	
	public void associate(Session session) {
		this.session = session;
	}

	public abstract void save(String name);

	public abstract void load(String name);

	public abstract String[] getShopNames();

	public abstract boolean exists(String name);
}
