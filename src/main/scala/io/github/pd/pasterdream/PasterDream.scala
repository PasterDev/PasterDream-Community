package io.github.pd.pasterdream

import io.github.pd.pasterdream.proxies.CommonProxy
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.{Mod, SidedProxy}

@Mod(
  modid = PasterDream.MODID,
  version = PasterDream.VERSION,
  modLanguage = "scala",
  acceptedMinecraftVersions = "[1.12,)")
object PasterDream {
  final val VERSION = "1.0.0"
  final val MODID = "pasterdream"
  @SidedProxy(modId = "pasterdream", serverSide = "io.github.pd.pasterdream.proxies.CommonProxy", clientSide = "io.github.pd.pasterdream.proxies.ClientProxy")
  var proxy: CommonProxy = _

  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = proxy.preInit(event)

  @EventHandler
  def init(event: FMLInitializationEvent): Unit = proxy.init(event)

  @EventHandler
  def postInit(event: FMLPostInitializationEvent): Unit = proxy.postInit(event)
}