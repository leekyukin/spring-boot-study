const monster = document.getElementById("monster");
const boomm = document.getElementById("boomm");
const atomic = document.getElementById("atomic");

function sleep(ms) {
    const wakeUpTime = Date.now() + ms;
    while (Date.now() < wakeUpTime) {}
  }

var count = 0;

  monster.addEventListener("mousedown", () => {
    if(count == 4) {
        atomic.classList.remove("hidden");
        return;
    }
    boomm.classList.remove("hidden")

})

monster.addEventListener("mouseup", () => {
    if(count == 4) {
        atomic.classList.add("hidden")
        count = 0;
    }
    boomm.classList.add('hidden')
    count++;
})

