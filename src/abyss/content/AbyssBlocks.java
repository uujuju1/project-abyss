package abyss.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import abyss.content.*;
import abyss.world.blocks.defense.*;

import static mindustry.type.ItemStack.with;

public class AbyssBlocks implements ContentList {
	public static Block 
		// walls
		voidWall, voidWallLarge, voidWallHuge,
		// units
		abyssFactory, add, mult, exp, tetr,
		// production 
		abyssForge;

	@Override
	public void load() {
		voidWall = new UnstableWall("void-wall") {{
			requirements(Category.defense, with(
				AbyssItems.abyss, 6
			));
			size = 1;
			health = 830;
			damage = 120;
			damageRadius = 40;
		}};
		voidWallLarge = new  UnstableWall("void-wall-large") {{
			requirements(Category.defense, with(
				AbyssItems.abyss, 24
			));
			size = 2;
			health = 830 * 4;
			damage = 300;
			damageRadius = 80;
		}};
		voidWallHuge = new UnstableWall("void-wall-huge") {{
			requirements(Category.defense, with(
				AbyssItems.abyss, 54
			));
			size = 3;
			health = 830 * 9;
			damage = 750;
			damageRadius = 120;
		}};

		abyssFactory = new UnitFactory("abyss-factory") {{
			requirements(Category.units, with(
				AbyssItems.Abyss, 120,
				Items.silicon, 150,
				Items.graphite, 130
			));
			size = 3;
			health = 220;
			consumes.power(1.3f);
			plans = Seq.with(
				new UnitPlan(AbyssUnitTypes, 60f * 40f, with(Items.silicon, 20, AbyssItems.abyss, 35))
			);
		}};
		add = new Reconstructor("reconstructor3"){{
			requirements(Category.units, with(Items.copper, 200, Items.lead, 120, Items.silicon, 90));

			size = 3;
			consumes.power(3f);
			consumes.items(with(Items.silicon, 40, Items.graphite, 40));

			constructTime = 60f * 10f;

			upgrades.addAll(
				new UnitType[]{AbyssUnitTypes.antra, AbyssUnitTypes.karma}
			);
		}};
		mult = new Reconstructor("reconstructor5"){{
			requirements(Category.units, with(Items.lead, 650, Items.silicon, 450, Items.titanium, 350, Items.thorium, 650));

			size = 5;
			consumes.power(6f);
			consumes.items(with(Items.silicon, 130, Items.titanium, 80, Items.metaglass, 40));

			constructTime = 60f * 30f;

			upgrades.addAll(
				new UnitType[]{AbyssUnitTypes.karma, AbyssUnitTypes.kalerbi}
			);
		}};

		abyssForge = new GenericCrafter("abyss-forge") {{
			requirements(Category.crafting, with(
				Items.titanium, 60,
				Items.plastanium, 80,
				Items.graphite, 125,
				Items.silicon, 150
			));
			size = 3;
			health = 220;
			itemCapacity = 20;
			craftTime = 90f;
			craftEffect = Fx.smelt;
			drawer = new DrawSmelter(Color.valueOf("B0B1B2"));
			consumes.items(with(
				Items.thorium, 3,
				Items.titanium, 2,
				Items.silicon, 5
			));
			consumes.power(5f);
			outputItem = new ItemStack(AbyssItems.abyss, 2);
		}};
	}
}