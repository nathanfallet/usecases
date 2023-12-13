# usecases

[![License](https://img.shields.io/github/license/nathanfallet/usecases)](LICENSE)
[![Issues](https://img.shields.io/github/issues/nathanfallet/usecases)]()
[![Pull Requests](https://img.shields.io/github/issues-pr/nathanfallet/usecases)]()
[![Code Size](https://img.shields.io/github/languages/code-size/nathanfallet/usecases)]()
[![codecov](https://codecov.io/gh/nathanfallet/usecases/graph/badge.svg?token=iIM9xwE4QT)](https://codecov.io/gh/nathanfallet/usecases)

UseCase utils for all my libs.

## Installation

Add dependency to your `build.gradle` or `pom.xml`:

```groovy
compile 'me.nathanfallet.usecases:usecases:1.5.3'
```

```xml

<dependency>
    <groupId>me.nathanfallet.usecases</groupId>
    <artifactId>usecases-jvm</artifactId>
    <version>1.5.3</version>
</dependency>
```

Or in a JS project with:

```bash
npm install usecases-kt
```

```bash
yarn add usecases-kt
```

## Usage

### First UseCase

Create a new class that extends `IUseCase` or `ISuspendUseCase`:

```kotlin
interface IMyUseCase : IUseCase<Input, Output>
```

```kotlin
class MyUseCase(
    private val dependency1: Dependency1,
    // ...
) : IMyUseCase {

    // If you want to use suspend functions, use `ISuspendUseCase` instead
    override fun invoke(input: Input): Output {
        // Do something with dependencies
        // ...

        // Return output
        return Output()
    }

}
```

Then, you can use it like this: (example with Koin, but you can use any DI library, or even instantiate it manually)

```kotlin
single<IMyUseCase> { MyUseCase(get(), /*...*/) }
```

```kotlin
val useCase = get<IMyUseCase>()
val output = useCase(Input())
```

### Variants

`IUseCase` and `ISuspendUseCase` are the base interfaces taking one input and returning one output.
We made some variants to make it easier to use:

- `IUnitUseCase` and `IUnitSuspendUseCase` for no input
- `IPairUseCase` and `IPairSuspendUseCase` for two inputs
- `ITripleUseCase` and `ITripleSuspendUseCase` for three inputs

### Models

A common use of UseCases is to make things with a model. That's why we made an interface for models with associated
UseCases:

```kotlin
data class MyModel(
    override val id: Long,
    val property1: String,
    // ...
) : IModel<Long, CreateMyModelPayload, UpdateMyModelPayload>
```

```kotlin
data class CreateMyModelPayload(
    val property1: String,
    // ...
)
```

```kotlin
data class UpdateMyModelPayload(
    val property1: String?,
    // ...
)
```

`CreateMyModelPayload` and `UpdateMyModelPayload` are payloads used to create and update the model.
In case you don't support creating or updating your model, you can use `Unit` instead.

Then, you can create and use associated UseCases:

```kotlin
class GetMyModelUseCase : IGetModelUseCase<MyModel, Long> {
    /* ... */
}
```

```kotlin
class CreateMyModelUseCase : ICreateModelUseCase<MyModel, CreateMyModelPayload> {
    /* ... */
}
```

```kotlin
class UpdateMyModelUseCase : IUpdateModelUseCase<MyModel, Long, UpdateMyModelPayload> {
    /* ... */
}
```

```kotlin
class DeleteMyModelUseCase : IDeleteModelUseCase<MyModel, Long> {
    /* ... */
}
```

Expecting those interfaces can help you to make your code more generic and reusable.

Of course, you can also use suspending variants:
`IGetModelSuspendUseCase`, `ICreateModelSuspendUseCase`, `IUpdateModelSuspendUseCase` and `IDeleteModelSuspendUseCase`.

### Models with Repositories

We also provide `IModelRepository` and `IModelSuspendRepository` to make repositories for your models:

```kotlin
class MyModelRepository(
    private val dependency1: Dependency1,
    // ...
) : IModelRepository<MyModelRepository, MyModel, Long, CreateMyModelPayload, UpdateMyModelPayload> {

    override fun list(context: IContext?): Model? {
        /* ... */
    }

    override fun get(id: Id, context: IContext?): Model? {
        /* ... */
    }

    override fun create(payload: CreatePayload, context: IContext?): Model? {
        /* ... */
    }

    override fun update(id: Id, payload: UpdatePayload, context: IContext?): Boolean {
        /* ... */
    }

    override fun delete(id: Id, context: IContext?): Boolean {
        /* ... */
    }

}
```

Then, we provide default implementations for `IGetModelUseCase`, `ICreateModelUseCase`, `IUpdateModelUseCase`
and `IDeleteModelUseCase`:

```kotlin
class GetMyModelUseCase(
    private val repository: MyModelRepository
) : GetModelFromRepositoryUseCase<MyModel, Long>(repository)
```

```kotlin
class CreateMyModelUseCase(
    private val repository: MyModelRepository
) : CreateModelFromRepositoryUseCase<MyModel, CreateMyModelPayload>(repository)
```

```kotlin
class UpdateMyModelUseCase(
    private val repository: MyModelRepository
) : UpdateModelFromRepositoryUseCase<MyModel, Long, UpdateMyModelPayload>(repository)
```

```kotlin
class DeleteMyModelUseCase(
    private val repository: MyModelRepository
) : DeleteModelFromRepositoryUseCase<MyModel, Long>(repository)
```

Suspend variants are available too:
`GetModelFromRepositorySuspendUseCase`, `CreateModelFromRepositorySuspendUseCase`, `UpdateModelFromRepositorySuspendUseCase`
and `DeleteModelFromRepositorySuspendUseCase`.
