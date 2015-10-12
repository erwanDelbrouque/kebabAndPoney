package model.ressources;

public class MockedResourcePool extends ResourcePool<MockedResource> {
	
	public MockedResourcePool(int n) {
		super(n);
	}

	@Override
	protected MockedResource createResource() {
		return new MockedResource();
	}

}
