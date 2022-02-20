package abyss.world.blocks.payload;

import arc.util.*;
import mindustry.world.*;
import mindustry.world.blocks.payload.*;
// generic crafter that converts one payload into a different payload
public class PayloadConverter extends PayloadBlock {
	public @Nullable Block input, output;

	public float craftTime = 60f;

	public PayloadConverter(String name) {
		super(name);
	}

	public class PayloadConverterBuild extends PayloadBlock.PayloadBlockBuild {
		float progress = 0f;
		@Override
		public boolean acceptPayload(Building source, Payload payload) {
			if (payload == input && back() == source) return true;
		}

		@Override
		public void updateTile() {
			if (payload == input) {
				if (progress >= craftTime) {
					progress = 0f;
					payload = output;
				}
				progress += Time.delta;
			}
		}
	}
}