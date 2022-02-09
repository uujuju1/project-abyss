package abyss.content;

import arc.struct.Seq;
import mindustry.content.*;
import mindustry.content.TechTree.TechNode;
import mindustry.ctype.ContentList;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.*;
import mindustry.type.ItemStack;

public class AbyssTechTree implements ContentList {
	static TechTree.TechNode context = null;

	private static void extendNode (UnlockableContent parent, Runnable children) {
		context = TechTree.all.find(t -> t.content == parent);
		children.run();
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Seq <Objective> objectives, Runnable children) {
		TechNode node = new TechNode(context, content, requirements);
		if (objectives != null) node.objectives = objectives;

		TechNode prev = context;
		context = node;
		children.run();
		context = prev;
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Seq <Objective> objectives) {
		node(content, requirements, objectives, () -> {
		});
	}

	private static void node (UnlockableContent content, Seq <Objective> objectives) {
		node(content, content.researchRequirements(), objectives, () -> {
		});
	}

	private static void node (UnlockableContent content, ItemStack[] requirements) {
		node(content, requirements, Seq.with(), () -> {
		});
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Runnable children) {
		node(content, requirements, null, children);
	}

	private static void node (UnlockableContent content, Seq <Objective> objectives, Runnable children) {
		node(content, content.researchRequirements(), objectives, children);
	}

	private static void node (UnlockableContent content, Runnable children) {
		node(content, content.researchRequirements(), children);
	}

	private static void node (UnlockableContent block) {
		node(block, () -> {
		});
	}

	private static void nodeProduce (UnlockableContent content, Seq <Objective> objectives, Runnable children) {
		node(content, content.researchRequirements(), objectives.and(new Produce(content)), children);
	}

	private static void nodeProduce (UnlockableContent content, Seq <Objective> objectives) {
		nodeProduce(content, objectives, () -> {
		});
	}

	private static void nodeProduce (UnlockableContent content, Runnable children) {
		nodeProduce(content, Seq.with(), children);
	}

	private static void nodeProduce (UnlockableContent content) {
		nodeProduce(content, Seq.with(), () -> {
		});
	}

	@Override
	public void load() {
		extendNode(Items.plastanium, () -> {
			nodeProduce(AbyssItems.abyss);
		});
		extendNode(Items.metaglass, () -> {
			nodeProduce(AbyssItems.balestenite);
		});
		extendNode(Items.pyratite, () -> {
			nodeProduce(AbyssItems.kalenium);
		});

		extendNode(Blocks.plastaniumWall, () -> {
			node(AbyssBlocks.voidWall, Seq.with(new Produce(AbyssItems.abyss)), () -> {
				node(AbyssBlocks.voidWallLarge, () -> {
					node(AbyssBlocks.voidWallHuge);
				});
			});
		});

		extendNode(Blocks.titaniumConveyor, () -> {
			node(AbyssBlocks.kaleniumConveyor, Seq.with(new Produce(AbyssItems.kalenium)));
		});

		extendNode(Blocks.router, () -> {
			node(AbyssBlocks.kaleniumRouter, Seq.with(new Produce(AbyssItems.kalenium)));
		});
		
		extendNode(Blocks.itemBridge, () -> {
			node(AbyssBlocks.kaleniumBridge, Seq.with(new Produce(AbyssItems.kalenium)));
		});

		extendNode(Blocks.plastaniumCompressor, () -> {
			node(AbyssBlocks.abyssForge, Seq.with(new Produce(Items.thorium)), () -> {
				node(AbyssBlocks.crusher, Seq.with(new Produce(AbyssItems.abyss), new Research(Blocks.siliconCrucible)));
			});
		});
		extendNode(Blocks.kiln, () -> {
			node(AbyssBlocks.proximitySmelter, Seq.with(new Produce(Items.titanium)));
			node(AbyssBlocks.blastKiln, Seq.with(new Produce(Items.pyratite)));
		});

		extendNode(Blocks.additiveReconstructor, () -> {
			node(AbyssBlocks.add, ItemStack.with(Items.copper, 1));
		});
		extendNode(Blocks.multiplicativeReconstructor, () -> {
			node(AbyssBlocks.mult, ItemStack.with(Items.copper, 1));
		});
		extendNode(Blocks.exponentialReconstructor, () -> {
			node(AbyssBlocks.exp, ItemStack.with(Items.copper, 1));
		});
		extendNode(Blocks.tetrativeReconstructor, () -> {
			node(AbyssBlocks.tetr, ItemStack.with(Items.copper, 1));
		});

		extendNode(Blocks.salvo, () -> {
			node(AbyssBlocks.kardone, Seq.with(new Produce(AbyssItems.abyss)), () -> {
				node(AbyssBlocks.delamine, Seq.with(new Produce(Items.titanium)), () -> {
					node(AbyssBlocks.selena, Seq.with(new Produce(Items.thorium)), () -> {
						node(AbyssBlocks.kardeni, Seq.with(new Produce(Items.surgeAlloy)));
					});
				});
			});
		});
		extendNode(Blocks.arc, () -> {
			node(AbyssBlocks.liner, Seq.with(new Produce(AbyssItems.balestenite)));
		});
		extendNode(Blocks.lancer, () -> {
			node(AbyssBlocks.point, Seq.with(new Produce(AbyssItems.balestenite)));
		});
		
		extendNode(Blocks.airFactory, () -> {
			node(AbyssBlocks.rotorizedFactory, Seq.with(new Produce(AbyssItems.balestenite)), () -> {
				node(AbyssUnitTypes.antra, () -> {
					node(AbyssUnitTypes.karma, Seq.with(new Research(AbyssBlocks.add)), () -> {
						node(AbyssUnitTypes.kalerbi, Seq.with(new Research(AbyssBlocks.mult)), () -> {
							node(AbyssUnitTypes.kodene, Seq.with(new Research(AbyssBlocks.exp)), () -> {
								node(AbyssUnitTypes.tolonia, Seq.with(new Research(AbyssBlocks.tetr)));
							});
						});
					});
				});
			});
		});
		extendNode(Blocks.navalFactory, () -> {
			node(AbyssBlocks.abyssFactory, Seq.with(new Produce(AbyssItems.balestenite)), () -> {
				node(AbyssUnitTypes.katerni, () -> {
					node(AbyssUnitTypes.termina, Seq.with(new Research(AbyssBlocks.add)), () -> {
						node(AbyssUnitTypes.solanra, Seq.with(new Research(AbyssBlocks.mult)), () -> {
							node(AbyssUnitTypes.deuteria, Seq.with(new Research(AbyssBlocks.exp)), () -> {
								node(AbyssUnitTypes.atomega, Seq.with(new Research(AbyssBlocks.tetr)));
							});
						});
					});
				});
			});
			node(AbyssBlocks.specialistAssembler, Seq.with(new Research(UnitTypes.bryde)), () -> {
				node(AbyssUnitTypes.solenopsis, () -> {
					node(AbyssUnitTypes.cricetiae, Seq.with(new Research(AbyssBlocks.add)), () -> {
						node(AbyssUnitTypes.oryctolagus, Seq.with(new Research(AbyssBlocks.mult)), () -> {
							node(AbyssUnitTypes.carcharodon, Seq.with(new Research(AbyssBlocks.exp)), () -> {
								node(AbyssUnitTypes.orcinus, Seq.with(new Research(AbyssBlocks.tetr)));
							});
						});
					});
				});
			});
		});
		extendNode(Blocks.groundFactory, () -> {
			node(AbyssBlocks.terreniumConstructor, Seq.with(new Produce(AbyssItems.kalenium)), () -> {
				node(AbyssUnitTypes.saloni, () -> {
					node(AbyssUnitTypes.alerbite, Seq.with(new Research(AbyssBlocks.add)), () -> {
						node(AbyssUnitTypes.laminite, Seq.with(new Research(AbyssBlocks.mult)), () -> {
							node(AbyssUnitTypes.almone, Seq.with(new Research(AbyssBlocks.exp)), () -> {
								node(AbyssUnitTypes.aracnophobia, Seq.with(new Research(AbyssBlocks.tetr)));
							});
						});
					});
				});
			});
		});
	}
}