package de.neemann.digital.core.arithmetic;

import de.neemann.digital.core.Node;
import de.neemann.digital.core.NodeException;
import de.neemann.digital.core.ObservableValue;
import de.neemann.digital.core.element.AttributeKey;
import de.neemann.digital.core.element.Element;
import de.neemann.digital.core.element.ElementAttributes;
import de.neemann.digital.core.element.ElementTypeDescription;

import static de.neemann.digital.core.element.PinInfo.input;

/**
 * A multiplicator
 *
 * @author hneemann
 */
public class Mul extends Node implements Element {

    /**
     * The multiplicators description
     */
    public static final ElementTypeDescription DESCRIPTION
            = new ElementTypeDescription(Mul.class, input("a"), input("b"))
            .addAttribute(AttributeKey.Rotate)
            .addAttribute(AttributeKey.Label)
            .addAttribute(AttributeKey.Bits);

    private final ObservableValue mul;
    private final int bits;
    private ObservableValue a;
    private ObservableValue b;
    private long value;

    /**
     * Creates a new instance
     *
     * @param attributes the attributes
     */
    public Mul(ElementAttributes attributes) {
        bits = attributes.get(AttributeKey.Bits);
        this.mul = new ObservableValue("mul", bits * 2);
    }

    @Override
    public void readInputs() throws NodeException {
        value = a.getValue() * b.getValue();
    }

    @Override
    public void writeOutputs() throws NodeException {
        mul.setValue(value);
    }

    @Override
    public void setInputs(ObservableValue... inputs) throws NodeException {
        a = inputs[0].addObserverToValue(this).checkBits(bits, this);
        b = inputs[1].addObserverToValue(this).checkBits(bits, this);
    }

    @Override
    public ObservableValue[] getOutputs() {
        return new ObservableValue[]{mul};
    }

}
