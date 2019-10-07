package cz.czechitas.kockamyssyr.api;

import static java.awt.event.KeyEvent.*;

public enum KeyCode {

    A(VK_A), B(VK_B), C(VK_C), D(VK_D), E(VK_E), F(VK_F), G(VK_G), H(VK_H), I(VK_I), J(VK_J), K(VK_K), L(VK_L), M(VK_M), N(VK_N), O(VK_O), P(VK_P), Q(VK_Q), R(VK_R), S(VK_S), T(VK_T), U(VK_U), V(VK_V), W(VK_W), X(VK_X), Y(VK_Y), Z(VK_Z),
    KEY_1(VK_1), KEY_2(VK_2), KEY_3(VK_3), KEY_4(VK_4), KEY_5(VK_5), KEY_6(VK_6), KEY_7(VK_7), KEY_8(VK_8), KEY_9(VK_9), KEY_0(VK_0),
    UP(VK_UP), DOWN(VK_DOWN), LEFT(VK_LEFT), RIGHT(VK_RIGHT),
    ENTER(VK_ENTER), ALT(VK_ALT), CTRL(VK_CONTROL), SHIFT(VK_SHIFT), COMMAND(VK_CONTROL), SPACE(VK_SPACE);

    private int keyEventVkCode;

    KeyCode(int keyEventVkCode) {
        this.keyEventVkCode = keyEventVkCode;
    }

    public int getKeyEventVkCode() {
        return keyEventVkCode;
    }
}
