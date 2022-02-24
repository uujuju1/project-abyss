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
import mindustry.entities.bullet.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import abyss.content.*;
import abyss.graphics.*;
import abyss.world.blocks.defense.*;
import abyss.world.blocks.production.*;

import static mindustry.type.ItemStack.with;

public class AbyssBlocks implements ContentList {
	public static Block 
		// distribution
		kaleniumConveyor, kaleniumRouter, kaleniumBridge, kaleniumDistributor,
		// walls
		voidWall, voidWallLarge, voidWallHuge,
		selemateWall, selemateWallLarge, selemateWallHuge,
		// units
		abyssFactory, rotorizedFactory, terreniumConstructor, specialistAssembler,
		add, mult, exp, tetr,
		// production 
		abyssForge, proximitySmelter, blastKiln,
		plasticSolidifier, heavyRefiner, lightRefiner, rockFurncace,
		// powah
		oilBurner,
		// turrets
		kardone, delamine, selena, kardeni,
		liner, point,
		dwarf, sequence, neutron, singularity,
		// scatters
		assaultScatter, supportScatter, specialistScatter/*,
		// payload
		wallConverter*/;

	@Override
	public void load() {
		kaleniumConveyor = new Conveyor("kalenium-conveyor") {{
			requirements(Category.distribution, with(
				AbyssItems.kalenium, 1,
				Items.silicon, 1
			));
			speed = 0.1f;
			displayedSpeed = 14f;
			health = 125;
		}};
		kaleniumRouter = new Router("kalenium-router") {{
			requirements(Category.distribution, with(
				AbyssItems.kalenium, 1,
				Items.silicon, 2
			));
			speed = 0.1f;
			health = 154;
		}};
		kaleniumBridge = new BufferedItemBridge("kalenium-bridge") {{
			requirements(Category.distribution, with(
				AbyssItems.kalenium, 5,
				Items.silicon, 5,
				Items.lead, 5
			));
			speed = 79.6f;
			health = 250;
			range = 8;
			bufferCapacity = 25;
		}};
		kaleniumDistributor = new Router("kalenium-distributor") {{
			requirements(Category.distribution, with(
				AbyssItems.kalenium, 6,
				Items.silicon, 3
			));
			size = 2;
			speed = 0.1f;
			health = 850;
		}};

		voidWall = new UnstableWall("void-wall") {{
			requirements(Category.defense, with(
				AbyssItems.abyss, 6
			));
			size = 1;
			health = 830;
			damage = 120;
			damageRadius = 40;
			explodeEffect = AbyssFx.smallVoidExplosion;
		}};
		voidWallLarge = new  UnstableWall("void-wall-large") {{
			requirements(Category.defense, with(
				AbyssItems.abyss, 24
			));
			size = 2;
			health = 830 * 4;
			damage = 300;
			damageRadius = 80;
			explodeEffect = AbyssFx.mediumVoidExplosion;
		}};
		voidWallHuge = new UnstableWall("void-wall-huge") {{
			requirements(Category.defense, with(
				AbyssItems.abyss, 54
			));
			size = 3;
			health = 830 * 9;
			damage = 750;
			damageRadius = 120;
			explodeEffect = AbyssFx.largeVoidExplosion;
		}};
		selemateWall = new Wall("selemate-wall") {{
			requirements(Category.defense, with(
				AbyssItems.selemate, 6
			));
			size = 1;
			health = 500;
		}};
		selemateWallLarge = new Wall("selemate-wall-large") {{
			requirements(Category.defense, with(
				AbyssItems.selemate, 24
			));
			size = 2;
			health = 500 * 4;
		}};
		selemateWallHuge = new Wall("selemate-wall-huge") {{
			requirements(Category.defense, with(
				AbyssItems.selemate, 54
			));
			size = 3;
			health = 500 * 9;
		}};

		abyssFactory = new UnitFactory("abyss-factory") {{
			requirements(Category.units, with(
				AbyssItems.abyss, 120,
				Items.silicon, 150,
				Items.graphite, 130
			));
			size = 3;
			health = 220;
			consumes.power(1.3f);
			plans = Seq.with(
				new UnitPlan(AbyssUnitTypes.antra, 60f * 40f, with(Items.silicon, 20, AbyssItems.abyss, 35))
			);
		}};
		rotorizedFactory = new UnitFactory("rotorized-factory") {{
			requirements(Category.units, with(
				AbyssItems.balestenite, 150,
				Items.silicon, 120,
				Items.titanium, 100
			));
			size = 3;
			health = 220;
			consumes.power(2f);
			plans = Seq.with(
				new UnitPlan (AbyssUnitTypes.katerni, 60f * 30, with(Items.silicon, 10, AbyssItems.balestenite, 30))
			);
		}};
		terreniumConstructor = new UnitFactory("terrenium-constructor") {{
			requirements(Category.units, with(
				AbyssItems.kalenium, 150,
				AbyssItems.balestenite, 30,
				Items.silicon, 120,
				Items.titanium, 100
			));
			size = 3;
			health = 220;
			consumes.power(2f);
			plans = Seq.with(
				new UnitPlan (AbyssUnitTypes.saloni, 60f * 30, with(Items.silicon, 10, AbyssItems.kalenium, 30))
			);
		}};
		specialistAssembler = new UnitFactory("specialist-assembler") {{
			requirements(Category.units, with(
				Items.metaglass, 60,
				Items.silicon, 120,
				Items.titanium, 100
			));
			size = 3;
			health = 220;
			consumes.power(2f);
			plans = Seq.with(
				new UnitPlan (AbyssUnitTypes.solenopsis, 60f * 30, with(Items.silicon, 10, Items.metaglass, 30, Items.plastanium, 5))
			);
		}};
		add = new Reconstructor("reconstructor3") {{
			requirements(Category.units, with(Items.copper, 200, Items.lead, 120, Items.silicon, 90));

			size = 3;
			consumes.power(3f);
			consumes.items(with(Items.silicon, 40, Items.graphite, 40));

			constructTime = 60f * 10f;

			upgrades.addAll(
				new UnitType[]{AbyssUnitTypes.antra, AbyssUnitTypes.karma},
				new UnitType[]{AbyssUnitTypes.katerni, AbyssUnitTypes.termina},
				new UnitType[]{AbyssUnitTypes.saloni, AbyssUnitTypes.alerbite},
				new UnitType[]{AbyssUnitTypes.solenopsis, AbyssUnitTypes.cricetiae}
			);
		}};
		mult = new Reconstructor("reconstructor5") {{
			requirements(Category.units, with(Items.lead, 650, Items.silicon, 450, Items.titanium, 350, Items.thorium, 650));

			size = 5;
			consumes.power(6f);
			consumes.items(with(Items.silicon, 130, Items.titanium, 80, Items.metaglass, 40));

			constructTime = 60f * 30f;

			upgrades.addAll(
				new UnitType[]{AbyssUnitTypes.karma, AbyssUnitTypes.kalerbi},
				new UnitType[]{AbyssUnitTypes.termina, AbyssUnitTypes.solanra},
				new UnitType[]{AbyssUnitTypes.alerbite, AbyssUnitTypes.laminite},
				new UnitType[]{AbyssUnitTypes.cricetiae, AbyssUnitTypes.oryctolagus}
			);
		}};
		exp = new Reconstructor("reconstructor7") {{
			requirements(Category.units, with(Items.lead, 2000, Items.silicon, 1000, Items.titanium, 2000, Items.thorium, 750, Items.plastanium, 450, Items.phaseFabric, 600));

			size = 7;
			consumes.power(13f);
			consumes.items(with(Items.silicon, 850, Items.titanium, 750, Items.plastanium, 650));
			consumes.liquid(Liquids.cryofluid, 1f);

			constructTime = 60f * 60f * 1.5f;
			liquidCapacity = 60f;

			upgrades.addAll(
				new UnitType[]{AbyssUnitTypes.kalerbi, AbyssUnitTypes.kodene},
				new UnitType[]{AbyssUnitTypes.solanra, AbyssUnitTypes.deuteria},
				new UnitType[]{AbyssUnitTypes.laminite, AbyssUnitTypes.almone},
				new UnitType[]{AbyssUnitTypes.oryctolagus, AbyssUnitTypes.carcharodon}
			);
		}};
		tetr = new Reconstructor("reconstructor9") {{
			requirements(Category.units, with(Items.lead, 4000, Items.silicon, 3000, Items.thorium, 1000, Items.plastanium, 600, Items.phaseFabric, 600, Items.surgeAlloy, 800));

			size = 9;
			consumes.power(25f);
			consumes.items(with(Items.silicon, 1000, Items.plastanium, 600, Items.surgeAlloy, 500, Items.phaseFabric, 350));
			consumes.liquid(Liquids.cryofluid, 3f);

			constructTime = 60f * 60f * 4;
			liquidCapacity = 180f;

			upgrades.addAll(
				new UnitType[]{AbyssUnitTypes.kodene, AbyssUnitTypes.tolonia},
				new UnitType[]{AbyssUnitTypes.deuteria, AbyssUnitTypes.atomega},
				new UnitType[]{AbyssUnitTypes.almone, AbyssUnitTypes.aracnophobia}
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
		proximitySmelter = new ProximityCrafter("proximity-smelter") {{
			requirements(Category.crafting, with(
				Items.silicon, 200,
				Items.titanium, 150,
				Items.graphite, 250,
				Items.plastanium, 100
			));
			size = 3;
			health = 220;
			consumes.items(with(
				Items.copper, 4,
				Items.metaglass, 2
			));
			outputItem = new ItemStack(AbyssItems.balestenite, 2);
		}};
		blastKiln = new CrowdedCrafter("blast-kiln") {{
			requirements(Category.crafting, with(
				AbyssItems.balestenite, 300,
				Items.silicon, 450,
				Items.titanium, 350,
				Items.plastanium, 220
			));
			size = 4;
			health = 300;
			drawer = new DrawSmelter(Color.valueOf("FECEAD"));
			consumes.power(3f);
			consumes.items(with(
				Items.plastanium, 3,
				Items.silicon, 6,
				AbyssItems.balestenite, 4
			));
			outputItem = new ItemStack(AbyssItems.kalenium, 3);
		}};
		plasticSolidifier = new GenericCrafter("plastic-solidifier") {{
			requirements(Category.crafting, with(
				Items.plastanium, 80,
				Items.thorium, 50,
				Items.silicon, 120,
				AbyssItems.selemate, 80
			));
			size = 3;
			health = 220;
			drawer = new DrawLiquid();
			consumes.power(2.5f);
			consumes.items(with(
				Items.titanium, 4,
				Items.silicon, 6,
				AbyssItems.abyss, 5
			));
			consumes.liquid(AbyssItems.heavyOil, 0.16f);
			outputItem = new ItemStack(Items.plastanium, 4);
		}};
		heavyRefiner = new GenericCrafter("heavy-refiner") {{
			requirements(Category.crafting, with(
				Items.silicon, 60,
				Items.graphite, 30,
				AbyssItems.selemate, 80,
				Items.lead, 100
			));
			size = 2;
			health = 160;
			craftTime = 1f;
			drawer = new DrawLiquid();
			consumes.liquid(Liquids.oil, 0.2f);
			outputLiquid = new LiquidStack(AbyssItems.heavyOil, 0.1f);
		}};
		lightRefiner = new GenericCrafter("light-refiner") {{
			requirements(Category.crafting, with(
				Items.silicon, 60,
				Items.graphite, 30,
				AbyssItems.selemate, 80,
				Items.lead, 100
			));
			size = 2;
			health = 160;
			craftTime = 1f;
			drawer = new DrawLiquid();
			consumes.liquid(Liquids.oil, 0.2f);
			outputLiquid = new LiquidStack(AbyssItems.lightOil, 0.1f);
		}};
		rockFurncace = new GenericCrafter("rock-furnace") {{
			requirements(Category.crafting, with(
				Items.copper, 40,
				Items.lead, 80,
				Items.graphite, 30
			));
			size = 2;
			health = 160;
			craftTime = 30f;
			drawer = new DrawSmelter(Color.valueOf("E8DDD6"));
			consumes.items(with(
				Items.copper, 2,
				Items.lead, 2
			));
			outputItem = new ItemStack(AbyssItems.selemate, 2);
		}};

		oilBurner = new ItemLiquidGenerator(false, true, "oil-burner") {{
			requirements(Category.power, with(
				Items.silicon, 50,
				Items.graphite, 40,
				AbyssItems.selemate, 80,
				Items.lead, 75
			));
			size = 2;
			health = 160;
			liquidCapacity = 60f;
			consumes.liquid(AbyssItems.lightOil, 0.1f);
			powerProduction = 3f;
		}};

		kardone = new ItemTurret("kardone") {{
			requirements(Category.turret, with(
				AbyssItems.abyss, 20,
				Items.silicon, 15
			));
			size = 1;
			health = 220;
			reloadTime = 30f;
			range = 160f;
			inaccuracy = 2f;
			rotateSpeed = 7f;
			maxAmmo = 15;
			restitution = 0.05f;
			ammo(
				AbyssItems.abyss, AbyssBullets.voidBullet1
			);
		}};
		delamine = new ItemTurret("delamine") {{
			requirements(Category.turret, with(
				AbyssItems.abyss, 50,
				Items.silicon, 75,
				Items.titanium, 25
			));
			size = 2;
			health = 880;
			reloadTime = 60f;
			shots = 2;
			burstSpacing = 5f;
			range = 240f;
			maxAmmo = 35;
			restitution = 0.05f;
			inaccuracy = 2f;
			ammo(
				AbyssItems.abyss, AbyssBullets.voidBullet2
			);
		}};
		selena = new ItemTurret("selena") {{
			requirements(Category.turret, with(
				AbyssItems.abyss, 80,
				Items.silicon, 125,
				Items.thorium, 50,
				Items.titanium, 100,
				Items.plastanium, 80
			));
			size = 3;
			health = 1980;
			reloadTime = 120f;
			shots = 6;
			burstSpacing = 5f;
			range = 280f;
			maxAmmo = 75;
			restitution = 0.05f;
			inaccuracy = 2f;
			ammo(
				AbyssItems.abyss, AbyssBullets.voidBullet3
			);
		}};
		kardeni = new ItemTurret("kardeni") {{
			requirements(Category.turret, with(
				AbyssItems.abyss, 200,
				Items.surgeAlloy, 100,
				Items.silicon, 350,
				Items.thorium, 250,
				Items.titanium, 400,
				Items.graphite, 400
			));
			size = 4;
			health = 3520;
			reloadTime = 15f;
			shots = 2;
			burstSpacing = 1f;
			range = 360f;
			maxAmmo = 100;
			restitution = 0.05f;
			inaccuracy = 2f;
			ammo(
				AbyssItems.abyss, AbyssBullets.voidBullet4
			);
		}};
		liner = new PowerTurret("liner") {{
			requirements(Category.turret, with(
				AbyssItems.balestenite, 20,
				Items.silicon, 35
			));
			size = 1;
			health = 160;
			powerUse = 2.5f;
			reloadTime = 30f;
			shots = 3;
			burstSpacing = 5f;
			range = 120f;
			restitution = 0.05f;
			shootType = AbyssBullets.electraBullet1;
		}};
		point = new PowerTurret("point") {{
			requirements(Category.turret, with(
				AbyssItems.balestenite, 60,
				Items.silicon, 120,
				Items.titanium, 90
			));
			size = 2;
			health = 640;
			powerUse = 3.33f;
			reloadTime = 160f;
			range = 160f;
			restitution = 0.05f;
			shootType = AbyssBullets.electraBullet2;
		}};
		dwarf = new ItemTurret("dwarf") {{
			requirements(Category.turret, with(
				AbyssItems.singularityCore, 10,
				Items.graphite, 10,
				Items.lead, 15
			));
			size = 1;
			health = 180;
			reloadTime = 30f;
			range = 64f;
			restitution = 0.05f;
			inaccuracy = 1f;
			ammo(
				AbyssItems.singularityCore, AbyssBullets.singularityBullet1
			);
		}};
		sequence = new ItemTurret("sequence") {{
			requirements(Category.turret, with(
				AbyssItems.singularityCore, 30,
				Items.graphite, 20,
				Items.silicon, 25,
				Items.lead, 40
			));
			size = 2;
			health = 710;
			reloadTime = 45f;
			range = 120f;
			restitution = 0.05f;
			inaccuracy = 1f;
			ammo(
				AbyssItems.singularityCore, AbyssBullets.singularityBullet2
			);
		}};

		assaultScatter = new ScatterSilo("assault-scatter") {{
			requirements(Category.turret, with(
				AbyssItems.balestenite, 100,
				Items.silicon, 75,
				Items.titanium, 40
			));
			size = 2;
			health = 160;
			shootSound = Sounds.shootBig;
			consumes.items(with(
				AbyssItems.balestenite, 10
			));
			bullet = new BasicBulletType(4f, 20) {{
				width = 9f;
				height = 11f;
				lifetime = 20f;
			}};
		}};
		supportScatter = new ScatterSilo("support-scatter") {{
			requirements(Category.turret, with(
				AbyssItems.balestenite, 100,
				Items.silicon, 115
			));
			size = 2;
			health = 160;
			consumes.power(1f);
			shootSound = Sounds.noammo;
			bullet = new LaserBoltBulletType(4f, 10){{
				lifetime = 30f;
				healPercent = 0.5f;
				collidesTeam = true;
				frontColor = Pal.heal;
				backColor = Color.white;
			}};
		}};
		specialistScatter = new ScatterSilo("specialist-scatter") {{
			requirements(Category.turret, with(
				AbyssItems.balestenite, 120,
				Items.plastanium, 45,
				Items.silicon, 30
			));
			size = 2;
			health = 160;
			shootSound = Sounds.sap;
			consumes.items(with(
				Items.sporePod, 10
			));
			bullet = new MissileBulletType(4f, 15) {{
				lifetime = 30f;
				width = 9f;
				height = 11f;
				frontColor = Pal.sapBullet;
				backColor = Pal.sapBulletBack;
				status = StatusEffects.sapped;
				statusDuration = 60f * 10f;
			}};
		}};

		/*
		wallConverter = new PayloadConverter("wall-converter") {{
			requirements(Category.units, with(
				AbyssItems.singularityCore, 69
			));
			size = 3;
			health = 200;
			input = Blocks.copperWall;
			output = Blocks.titaniumWallLarge;
		}};
		*/
	}
}
