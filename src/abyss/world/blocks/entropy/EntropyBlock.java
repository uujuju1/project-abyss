package abyss.world.blocks.entropy;

import mindustry.gen.*;
import mindustry.world.Block;
import abyss.world.blocks.entropy.EntropyStorage;

/*based on Endless Rusting's pulse system
wont be available on the next releases but i will work on it*/

public class EntropyBlock extends Block {
	public EntropyBlock(String name) {
		super(name);
		solid = true;
		update = true;
		destructible = true;
	}

	public class EntropyBlockBuild extends Building {
		public EntropyStorage entropy = new EntropyStorage();
	}
}