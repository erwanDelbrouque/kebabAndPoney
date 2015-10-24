package model.ressources;

public class ResourcefulUser<R extends Resource> {
	
	protected String name;
	protected R resource;
	
	public ResourcefulUser(String name) {
		this.name = name;
	}
	
	public R getResource() {
		return resource;
		
	}
	
	public void setResource(R resource) {
		this.resource = resource;
		
	}
	
	public void resetResource() {
		this.resource = null;
		
	}
}