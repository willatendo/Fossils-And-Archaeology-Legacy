package willatendo.fossilslegacy.server.entity;

public enum DinosaurTypes {
	TRICERATOPS(12, 1.0F, 1.5F),
	VELOCIRAPTOR(8, 1.0F),
	TYRANNOSAURUS(8, 1.0F, 2.0F),
	PLESIOSAURUS(12, 0.5F, 1.0F),
	PTEROSAURUS(8, 0.5F, 1.0F),
	STEGOSAURUS(12, 1.0F, 1.5F),
	DILOPHOSAURUS(8, 1.0F),
	BRACHIOSAURUS(37, 1.0F, 5.0F),
	MAMMOTH(1.0F, 1.5F),
	SMILODON(2, 1.0F);

	private final float[] stepHeights;

	private DinosaurTypes(int growthStages, float minStepHeight, float maxStepHeight) {
		this.stepHeights = new float[growthStages];
		float diff = maxStepHeight - minStepHeight;
		float change = diff / growthStages;
		for (int i = 0; i < growthStages; i++) {
			this.stepHeights[i] = (float) Math.floor(minStepHeight + (change * ((float) i)));
		}
	}

	private DinosaurTypes(int growthStages, float stepHeight) {
		this.stepHeights = new float[growthStages];
		for (int i = 0; i < growthStages; i++) {
			this.stepHeights[i] = stepHeight;
		}
	}

	private DinosaurTypes(float... stepHeights) {
		this.stepHeights = stepHeights;
	}

	public float[] getStepHeights() {
		return stepHeights;
	}
}
