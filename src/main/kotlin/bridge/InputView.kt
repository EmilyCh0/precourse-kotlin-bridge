package bridge

import bridge.Bridge.Companion.MAX_BRIDGE_LENGTH
import bridge.Bridge.Companion.MIN_BRIDGE_LENGTH
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(READ_BRIDGE_LENGTH)
        val input = Console.readLine()
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(NOT_NUMBER_ERROR)
        }
        if (input.toInt() !in MIN_BRIDGE_LENGTH..MAX_BRIDGE_LENGTH) {
            throw IllegalArgumentException(OUT_OF_RANGE_ERROR)
        }
        return input.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(READ_MOVING)
        val input = Console.readLine()
        if (!(input == UP_COMMAND || input == DOWN_COMMAND)) {
            throw IllegalArgumentException(WRONG_INPUT)
        }
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(READ_RETRY_OR_QUIT)
        val input = Console.readLine()
        if (!(input == RETRY_COMMAND || input == QUIT_COMMAND)) {
            throw IllegalArgumentException(WRONG_INPUT)
        }
        return input
    }

    companion object {
        const val READ_BRIDGE_LENGTH = "다리의 길이를 입력해주세요."
        const val READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        const val READ_RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        const val NOT_NUMBER_ERROR = "[ERROR] 숫자가 아닙니다."
        const val OUT_OF_RANGE_ERROR = "[ERROR] 3이상 20이하가 아닙니다."
        const val WRONG_INPUT = "[ERROR] 잘못된 입력입니다."
        const val UP_COMMAND = "U"
        const val DOWN_COMMAND = "D"
        const val RETRY_COMMAND = "R"
        const val QUIT_COMMAND = "Q"
    }
}
