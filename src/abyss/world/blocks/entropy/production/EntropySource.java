package abyss.world.blocks.entropy.production;

import arc.*;
import arc.math.*;
import arc.graphics.g2d.*;
import abyss.world.blocks.entropy.EntropyBlock;

public class EntropySource extends EntropyBlock {
	public float productionSpeed = 0.007f;
	public float maxProducion = 100f;

	public TextureRegion top;

	public EntropySource(String name) {
		super(name);
	}

	@Override
	public void load() {
		super.load();
		top = Core.atlas.find(name + "-top");
	}

	public class EntropySourceBuild extends EntropyBlock.EntropyBlockBuild {
		@Override
		public void updateTile() {
			super.updateTile();
			setEntropy(Mathf.approachDelta(entropy.entropy, maxProducion - 1f, productionSpeed));
		}

		@Override 
		public void draw() {
			super.draw();
			Draw.color(entropyColor);
			Draw.alpha(entropy.entropy/maxProducion);
			Draw.rect(top, x, y, 0);
		}
	}
}