#TINKERS' CONSTRUCT WITH ARMOR HACK

If you're using a mod like Thermal Foundation, Simple Ores, or Metallurgy, etc. you don't need this hack. This just adds a couple pieces of armor.

If you use this version of the mod be sure not to bother those responsible for Tinkers' Construct about any bugs.

So I'm playing with TCon, Rotarycraft, and Ars Magica 2 and I go to make bronze armor and it isn't there! Now I gotta add another mod to add an armor set for a metal I already have! This sucks. TCon already adds wood armor and its traveller's gear. If you poke around the source and resources you'll see it almost but not quite has a fully implemented armor system with alot of code behind it. I'm talking casting and modifying armor like you do tools. This is pretty sweet but TCon for 1.7.10 is pretty much finalized due to a change of hands. Don't get me wrong, though, this mod has changed from one set of talented hands to another set of talented hands and I like where this is going. However, I'm still playing 1.7.10 because it has all the best mods at the moment. Big mods like Thermal Expansion and ProjectRed do even have a beta for 1.8.x or 1.9.x yet. Long story short, most of the requisite code is already here so I just hacked some extra armor in.

Extra graphics were lifted from [Thermal Foundation](http://teamcofh.com) by Team CoFH where the art is licensed under CC BY-SA 4. I copied the relevant graphics twice in assets/thermalfoundation and also into assets/tinker and renamed them so the code will automagically detect them. Copy locations are in assets/thermalfoundation/textures. The images, no matter where copied, still are under the license in assets/thermalfoundation/LICENSE - ART.txt

The source code seems to be under CC Zero. Any modifications I've made in this fork are under the same license.

Source modified:
tinker.armor.TinkerArmor

Rest of README is as it was:

#TINKERS' CONSTRUCT IS UNDERGOING A REWRITE
The current 1.7.10 version of Tinkers' Construct is the final one for this iteration. Only major bugs will be fixed.
The rework is aimed at 1.8 and has no time-plan. It'll be ready when it's done.

#[Tinkers' Construct](http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2218638-tinkers-construct)

Modify all the things, then do it again!   
Melt down any metals you find. 	 
Power the world with spinning wind!

##Development
Install Forge as usual, and setup your IDE as with any other Forge project. Forge Multipart, and CClib must be installed from the  Forge File Server: The DEVELOPMENT version of NEI must be installed to the same directory from [Chicken Bones Site](http://www.chickenbones.craftsaddle.org/Files/New_Versions/links.php). Copy `TCore_dummy.jar` to `forge/mcp/jars/mods/` to enable the Preloader (optional -- only needed when working on the preloader itself)

## IMC
All IMC support and examples can be found here: https://gist.github.com/bonii-xx/e46f9d9e81e29d796b1b

##Compile from Source
Note: Git MUST be installed and in the system path to use our scripts.
* Setup: Run [gradle]in the repository root: `gradlew[.bat] [setupDevWorkspace|setupDecompWorkspace] [eclipse|idea]`
* Build: Run [gradle]in the repository root: `gradlew[.bat] build'
* If obscure Gradle issues are found try running 'gradlew clean' and 'gradlew cleanCache'

##Issue reporting
Please include the following:

* Minecraft version
* Tinkers' Construct version
* Forge version/build
* Versions of any mods potentially related to the issue 
* Any relevant screenshots are greatly appreciated.
* For crashes:
	* Steps to reproduce
	* ForgeModLoader-client-0.log (the FML log) from the root folder of the client

##Licenses
Most code is public domain under [Creative Commons 0](http://creativecommons.org/publicdomain/zero/1.0/). The rework will be licensed under the [MIT License](https://tldrlegal.com/license/mit-license)

Textures and binaries are licensed under [Creative Commons 3](http://creativecommons.org/licenses/by/3.0/).

Any modpack which uses Tinkers' Construct takes **full** responsibility for user support queries. For anyone else, we only support official builds from the main CI server, not custom built jars. We also do not take bug reports for outdated builds of Minecraft.

If you have queries about any license or the above support restrictions, please drop by our IRC channel, #TinkersConstruct on irc.esper.net

Any alternate licenses are noted where appropriate.

##Jar Signing
Some jars from our build servers may be signed. Under no circumstances does anyone have permission to verify the signatures on those jars from other mods. The signing is for informational purposes only.
