NAME = TFMG
PREFIX = /usr

all:
	$(MAKE) clear
	$(MAKE) release

b:
	$(MAKE) release

release:
	sh gradlew build	
	sleep 1
	sh -c "cp -r ./build/libs/tfmg-1.1.0c.jar ~/.local/share/PrismLauncher/instances/Test\ mods\ 1.21.1/minecraft/mods/"
	$(MAKE) install.core

clear:
	rm -rf src/generated 
	sh gradlew clean
	sh gradlew runData

install.core:
	# @if [ ! -f ./build/libs/tfmg-1.1.0c.jar ]; then echo -en "You need to run $(MAKE) all first.\n" && exit 1; fi
	# @echo -en "!NOTE: Please note make install does not compile tfmg and only installs the already built files."	
	@echo "done :3"

install: install.core

uninstall:
