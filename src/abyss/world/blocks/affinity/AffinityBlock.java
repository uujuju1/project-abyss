package abyss.world.blocks.affinity;

import mindustry.gen.*;
import mindustry.world.Block;

public class AffinityBlock extends Block {
	public AffinityBlock(String name) {
		super(name);
		solid = destructible = true;
	}
	public class AffinityBlockBuild extends Building {}
}