package io.github.pd.pasterdream.proxies

import io.github.pd.pasterdream.util.ResourcePackUtil
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

class ClientProxy extends CommonProxy {
  override def preInit(e: FMLPreInitializationEvent): Unit = {
    super.preInit(e)
    ResourcePackUtil.fetchPack()
  }
}
