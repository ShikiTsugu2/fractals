package src.functions;

import src.graphic.Model;

public abstract class Function<E> {
    private final E argument;

    public Function(){
        argument = requestArg();
    }

    public Function(Model m){
        argument = fetchArg(m);
    }

    public E getArgument() {
        return argument;
    }

    public abstract E fetchArg(Model m);

    public abstract E requestArg();

    public abstract Complexe calculate(Complexe z);
}
