package mockedclasses.resources;

import model.ressources.pools.ResourcePool;

public class MockedResourcePool extends ResourcePool<MockedResource> {
	
	
	public MockedResourcePool(String name, int n) throws NullPointerException, IllegalArgumentException {
		super(name, n);
	}

	public MockedResourcePool(int n) throws NullPointerException, IllegalArgumentException {
		super("Mocked", n);
	}

	@Override
	public MockedResource createResource() {
		return new MockedResource();
	}

	public String getName() {
		return name;
	}
	
}
