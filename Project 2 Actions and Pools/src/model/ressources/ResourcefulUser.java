package model.ressources;

public class ResourcefulUser<R extends Resource> {
	
	protected R resource;
	
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