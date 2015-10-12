package model.ressources;

import model.ressources.Resource;

public class MockedResource implements Resource {
	
	@Override
	public String description() {
		return "A mocked resource";
	}

}
