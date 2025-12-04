sh ./gradlew clean &&
    sh ./gradlew build &&
    sleep 1
rm ~/.local/share/PrismLauncher/instances/Test\ mods\ 1.21.1/minecraft/mods/tfmg* &&
    sleep 1
cp -r ./build/libs/tfmg-1.1.0c.jar ~/.local/share/PrismLauncher/instances/Test\ mods\ 1.21.1/minecraft/mods/
echo "dones :3"
