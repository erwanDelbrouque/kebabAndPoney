package mockedclasses.resources;

import model.ressources.pools.ResourcePool;

public class MockedResourcePool extends ResourcePool<MockedResource> {
	
	public MockedResourcePool(int n) {
		super("Mocked", n);
	}

	@Override
	public MockedResource createResource() {
		return new MockedResource();
	}
	
}
