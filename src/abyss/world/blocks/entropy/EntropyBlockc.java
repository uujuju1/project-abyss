package abyss.world.blocks.entropy;

import arc.graphics.Color;
import arc.util.Nullable;
import mindustry.gen.Building;
import abyss.world.blocks.entropy.EntropyStorage;

public interface EntropyBlockc {
	default float entropyPower() {
		return 1;
	}
	default void handleEntropy(float entropy) {
		handleEntropy(entropy, null);
	}
	default void handleEntropy(float entropy, @Nullable Building build) {
		entropyStorage().entropy += entropy; 
	}
	default boolean recieveEntropy(float entropy, Building src) {
		handleEntropy(entropy);
		return true;
	}
	default EntropyStorage entropyStorage() {
		return null;
	}
	default boolean canRecieveEntropy() {
		return false;
	}
	default void overflowEntropy() {}
	default void normalizeEntropy() {
		if (entropyStorage().entropy < 0f) entropyStorage().entropy = 0f;
	}
}