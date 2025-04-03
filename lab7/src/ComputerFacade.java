class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void turnOn() {
        cpu.boot();
        memory.load("0x00", "Данные ОС");
        hardDrive.readData("Загрузочный сектор");
        System.out.println("Компьютер включён");
    }

    public void turnOff() {
        hardDrive.writeData("Сектор сохранения", "Информация о завершении работы");
        memory.clear();
        cpu.shutdown();
        System.out.println("Компьютер выключен");
    }
}
